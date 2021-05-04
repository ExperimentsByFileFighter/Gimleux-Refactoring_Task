package de.dhbwka.cinema;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String result = "de.dhbwka.cinema.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = amountFor(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental singleRental) {
        double price;
        switch (singleRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                price = calculateAmount(singleRental, 2, 2,1.5);
                break;
            case Movie.NEW_RELEASE:
                price = calculateAmount(singleRental, 0, 0,3);
                break;
            case Movie.CHILDRENS:
                price = calculateAmount(singleRental, 1.5, 3, 1.5);
                break;
            default:
                price = 0;
        }
        return price;
    }

    private double calculateAmount(Rental rental, double basicPrice, int includedPeriod, double multiplicationFactor) {
        double price = basicPrice;
        if (rental.getDaysRented() > includedPeriod)
            price += (rental.getDaysRented() - includedPeriod) * multiplicationFactor;
        return price;
    }

}
    