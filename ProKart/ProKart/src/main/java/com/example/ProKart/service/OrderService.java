package com.example.ProKart.service;

import com.example.ProKart.dto.request.ItemRequest;
import com.example.ProKart.dto.request.OrderRequest;
import com.example.ProKart.dto.response.OrderResponse;
import com.example.ProKart.exception.CustomerNotFoundException;
import com.example.ProKart.exception.OrderRepository;
import com.example.ProKart.exception.ProductNotAvailableException;
import com.example.ProKart.model.Customer;
import com.example.ProKart.model.Enum.ProductStatus;
import com.example.ProKart.model.OrderEntity;
import com.example.ProKart.model.Product;
import com.example.ProKart.repo.CustomerRepository;
import com.example.ProKart.repo.ProductRepository;
import com.example.ProKart.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Optional<Customer> customerOptional = customerRepository.findByEmail(orderRequest.getCustomerEmail());
        if(customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Email is not valid");
        }

        Customer customer = customerOptional.get();

        List<Product> productsRequested = new ArrayList<>();
        int totalValue = 0;

        for(ItemRequest itemRequest: orderRequest.getItemRequests()) {
            Optional<Product> optionalProduct = productRepository.findById(itemRequest.getId());

            if(optionalProduct.isEmpty()) {
                throw new ProductNotAvailableException("Sorry, the product id=" + itemRequest.getId()+" is invalid");
            }
            Product product = optionalProduct.get();
            if(product.getQuantity() < itemRequest.getRequiredQuantity()) {
                throw new ProductNotAvailableException("Sorry, the product with id = "+product.getId()+" is out of stock");
            }

            product.setQuantity(product.getQuantity()-itemRequest.getRequiredQuantity());
            if(product.getQuantity()==0) {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
            totalValue += itemRequest.getRequiredQuantity()*product.getPrice();
            productsRequested.add(product);
        }

        // complete the order entity and save it
        OrderEntity order = OrderTransformer.orderRequestToOrderEntity(totalValue);
        order.setCustomer(customer);
        order.setProducts(productsRequested);
        OrderEntity savedOrder = orderRepository.save(order);

        // complete product and customer entity and save them as well
        for(Product product: productsRequested) {
            product.getOrders().add(savedOrder);
        }

        customer.getOrders().add(savedOrder);
        //save customer and product
        customerRepository.save(customer); // customer + order;
        productRepository.saveAll(productsRequested);

        // return the response;
        return OrderTransformer.orderToOrderResponse(savedOrder);
    }
}
