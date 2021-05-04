package de.dhbwka.cinema;

public class PriceChildren extends Price{
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int rentalLength) {
        return calculateCosts(1.5, 3, 1.5, rentalLength);
    }
}
