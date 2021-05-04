package de.dhbwka.cinema;

public class PriceNewRelease extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int rentalLength) {
        return calculateCosts(0, 0, 3, rentalLength);
    }

    @Override
    int getFrequentRenterPoints(int rentalLength) {
        return rentalLength > 1 ? 2 : 1;
    }
}
