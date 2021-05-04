import de.dhbwka.cinema.Customer;
import de.dhbwka.cinema.Movie;
import de.dhbwka.cinema.Rental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRental {
    @Test
    public void testMain() {
        String customerName0 = "Gimli son of Glóin";
        String customerName1 = "Legolas Greenleaf";


        Customer customer0 = new Customer(customerName0);
        Customer customer1 = new Customer(customerName1);

        String[] movieTitles = {
                "The Lord of the Rings - The Fellowship of the Ring",
                "The Lord of the Rings - The Two Towers",
                "The Lord of the Rings - The Return of the King",
                "Born of Hope"
        };
        int[] moviePrices = {
                1,2,2,0
        };
        int[] days = {
                123,
                456,
                789,
                147
        };
        Movie[] movies = {
                new Movie(movieTitles[0], moviePrices[0]),
                new Movie(movieTitles[1], moviePrices[1]),
                new Movie(movieTitles[2], moviePrices[2]),
                new Movie(movieTitles[3], moviePrices[3])
        };
        Rental[] rentals = {
                new Rental(movies[0], days[0]),
                new Rental(movies[1], days[1]),
                new Rental(movies[2], days[2]),
                new Rental(movies[3], days[3])
        };

        customer0.addRental(rentals[0]);
        customer1.addRental(rentals[1]);
        customer0.addRental(rentals[2]);
        customer1.addRental(rentals[3]);

        String expectedOutput0 = "de.dhbwka.cinema.Rental Record for "+customerName0+"\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tThe Lord of the Rings - The Fellowship of the Ring\t\t123\t369.0\n" +
                "\tThe Lord of the Rings - The Return of the King\t\t789\t1180.5\n" +
                "Amount owed is 1549.5\n" +
                "You earned 3 frequent renter points";
        String expectedOutput1 = "de.dhbwka.cinema.Rental Record for Legolas Greenleaf\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tThe Lord of the Rings - The Two Towers\t\t456\t681.0\n" +
                "\tBorn of Hope\t\t147\t219.5\n" +
                "Amount owed is 900.5\n" +
                "You earned 2 frequent renter points";

        String actualOutput0 = customer0.statement();
        String actualOutput1 = customer1.statement();

        assertEquals(expectedOutput0, actualOutput0);
        assertEquals(expectedOutput1, actualOutput1);
    }
}
