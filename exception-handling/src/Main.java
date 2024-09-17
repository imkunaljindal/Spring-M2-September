public class Main {
    public static void main(String[] args) {

        System.out.println("A");
        int a = 5;
        int b = 2;
        int arr[] = {1,2,3};
        try{
          int c = a/b;
          System.out.println("D");
            System.out.println(arr[4]);
        }
        catch (ArithmeticException e){
            System.out.println("C");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("E");
        }
        System.out.println("B");
    }
}