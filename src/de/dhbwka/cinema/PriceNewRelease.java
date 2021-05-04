package de.dhbwka.cinema;

public class PriceNewRelease extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getPrice(Rental rental) {
        return 0;
    }
}
