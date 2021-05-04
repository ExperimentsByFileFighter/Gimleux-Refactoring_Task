package de.dhbwka.cinema;

public abstract class Price {
    abstract int getPriceCode();
    abstract double getPrice(Rental rental);
    abstract double getCharge(int rentalLength);
    int getFrequentRenterPoints(int rentalLength) {
        return 1;
    }
}
