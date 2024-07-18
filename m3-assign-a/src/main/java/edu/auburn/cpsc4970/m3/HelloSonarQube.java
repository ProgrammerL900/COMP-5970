package edu.auburn.cpsc4970.m3;


/**
 * Simple Java Application
 *
 */
public class HelloSonarQube extends NullPointerException
{

    public static final String VALUE_PREFIX = "Value = ";
    public static final String LENGTH_PREFIX = " Length = ";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Too much into to console if replaced with logger

        HelloSonarQube helloSonarQube = new HelloSonarQube();
        helloSonarQube.printValue(null);
    }


    private void printValue(String value) {
        if (value == null) {
            throw new NullPointerException();
        }

        System.out.println(VALUE_PREFIX+value+LENGTH_PREFIX+value.length());








    }
}
