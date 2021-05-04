package de.dhbwka.cinema;

public class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    double amountFor() {
        double price;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                price = calculateAmount( 2, 2,1.5);
                break;
            case Movie.NEW_RELEASE:
                price = calculateAmount( 0, 0,3);
                break;
            case Movie.CHILDRENS:
                price = calculateAmount( 1.5, 3, 1.5);
                break;
            default:
                price = 0;
        }
        return price;
    }

    private double calculateAmount(double basicPrice, int includedPeriod, double multiplicationFactor) {
        double price = basicPrice;
        if (getDaysRented() > includedPeriod)
            price += (getDaysRented() - includedPeriod) * multiplicationFactor;
        return price;
    }
}