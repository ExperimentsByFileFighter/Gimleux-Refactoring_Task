package de.dhbwka.cinema;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program
{
    /**
     * This is the main entry point for the application
     */


    public static void main(String[] args)
    {
        String result;
        System.out.println("Welcome to the de.dhbwka.cinema.Movie Store");
        Movie m1 = new Movie("The Hunger Games", Movie.REGULAR);
        Movie m2 = new Movie("The Hunger Games - Catching Fire", Movie.NEW_RELEASE);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("Katniss Everdeen");
        c1.addRental(r1);
        c1.addRental(r2);
        System.out.println("Let's get the Statement");
        result = c1.statement();
        System.out.println(result);
    }
}


