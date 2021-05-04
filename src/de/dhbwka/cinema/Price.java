package de.dhbwka.cinema;

public abstract class Price {
    abstract int getPriceCode();
    abstract double getPrice(Rental rental);
    int getFrequentRenterPoints(int rentalLength) {
        return 1;
    }

    double getCharge(int rentalLength) {
        switch (getPriceCode()) {
            case Movie.REGULAR:
                return calculateAmount(2, 2,1.5, rentalLength);
            case Movie.NEW_RELEASE:
                return calculateAmount(0, 0,3, rentalLength);
            case Movie.CHILDRENS:
                return calculateAmount(1.5, 3, 1.5, rentalLength);
            default:
                return  0;
        }
    }

    private double calculateAmount(double basicPrice, int includedPeriod, double pricePerExtraDay, int rentalLength) {
        double price = basicPrice;
        if (rentalLength > includedPeriod)
            price += (rentalLength - includedPeriod) * pricePerExtraDay;
        return price;
    }

    public static Price createPrice(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                return new PriceRegular();
            case Movie.NEW_RELEASE:
                return new PriceNewRelease();
            case Movie.CHILDRENS:
                return new PriceChildren();
            default:
                throw new IllegalArgumentException("Price Code " + priceCode + " does not exist.");
        }
    }
}
