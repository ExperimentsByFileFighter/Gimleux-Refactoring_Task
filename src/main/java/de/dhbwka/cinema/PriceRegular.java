package de.dhbwka.cinema;

public class PriceRegular extends Price{
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int rentalLength) {
        return calculateCosts(2, 2,1.5, rentalLength);
    }
}
