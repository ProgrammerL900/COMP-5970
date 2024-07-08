package edu.auburn.cpsc4970.m1;

/**
 * Hello world!
 *
 */
public class SimpleApp
{
   public int addNumbers(int x, int y) {
       int sum = x + y;
       return sum;
   }
    public static void main( String[] args )
    {

        System.out.println( "War Eagle!" );
        int num1 = 1;
        int num2 = 1;
        SimpleApp obj = new SimpleApp();
        int result = obj.addNumbers(num1, num2);
        System.out.println(result);


    }
    /** Add method here to add two integers **/



}
