package de.dhbwka.cinema;

public class PriceRegular extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getPrice(Rental rental) {
        return 0;
    }
}
