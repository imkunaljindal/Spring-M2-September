public class Main {
    public static void main(String[] args) {
        System.out.println("A");
        int a = 5;
        int b = 0;
        try{
          int c = a/b;
          System.out.println("D");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("C");
        }
        finally{
            System.out.println("F");
        }

        try{
            int x = 5/0;
        }
        catch (ArithmeticException e) {
            System.out.println("G");
        }
        finally {
            System.out.println("H");
        }
        System.out.println("B");
    }
}