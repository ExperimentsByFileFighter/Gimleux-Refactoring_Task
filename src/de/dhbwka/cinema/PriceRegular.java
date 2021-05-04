package de.dhbwka.cinema;

public class PriceRegular extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int rentalLength) {
        return calculateCosts(2, 2,1.5, rentalLength);
    }
}
