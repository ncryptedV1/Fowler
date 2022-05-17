package de.ncrypted.fowler;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program {

  /**
   * This is the main entry point for the application
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the de.ncrypted.fowler.Movie Store");
    Movie m1 = new Movie("movie1", Movie.PriceCode.NEW_RELEASE);
    Movie m2 = new Movie("movie2", Movie.PriceCode.CHILDREN);
    Rental r1 = new Rental(m1, 10);
    Rental r2 = new Rental(m2, 5);
    Customer c1 = new Customer("joe");
    c1.addRental(r1);
    c1.addRental(r2);
    System.out.println("Let's get the Statement");
    String result = c1.generateStatement();
    System.out.println(result);
  }
}


