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

    double getCharge() {
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

    private double calculateAmount(double basicPrice, int includedPeriod, double pricePerExtraDay) {
        double price = basicPrice;
        if (getDaysRented() > includedPeriod)
            price += (getDaysRented() - includedPeriod) * pricePerExtraDay;
        return price;
    }

    int getFrequentRenterPoints() {
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            return 2;
        return 1;
    }
}