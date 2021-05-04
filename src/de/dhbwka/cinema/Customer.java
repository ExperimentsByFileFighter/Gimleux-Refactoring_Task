package de.dhbwka.cinema;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("de.dhbwka.cinema.Rental Record for " + this.getName() + "\n")
                .append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental : rentals){
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t\t").append(rental.getDaysRented()).append("\t").append(rental.getMovie().getCharge(rental.getDaysRented())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n")
                .append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals){
            result += rental.getMovie().getCharge(rental.getDaysRented());
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        for (Rental rental : rentals){
            result += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
        }
        return result;
    }

}
    