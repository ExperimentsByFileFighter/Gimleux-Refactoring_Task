package de.dhbwka.cinema;

public class PriceChildren extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getPrice(Rental rental) {
        return 0;
    }

    @Override
    double getCharge(int rentalLength) {
        return 0;
    }
}
