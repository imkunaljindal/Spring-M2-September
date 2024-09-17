package com.example.ProKart.repo;

import com.example.ProKart.model.Customer;
import com.example.ProKart.model.Enum.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByAge(int age);

//    @Query(value = "select * from customer where gender = :g AND age >= :age",nativeQuery = true)
//    List<Customer> getCustomersByGenderAndAgeGreaterThan(String g, int age);

    @Query(value = "select c from Customer c where c.gender = :g AND c.age >= :age")
    List<Customer> getCustomersByGenderAndAgeGreaterThan(Gender g, int age);

    Optional<Customer> findByEmail(String email);
}
