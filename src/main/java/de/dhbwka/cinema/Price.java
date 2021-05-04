package de.dhbwka.cinema;

public abstract class Price {
    public abstract int getPriceCode();
    public int getFrequentRenterPoints(int rentalLength) {
        return 1;
    }

    public double getCharge(int rentalLength) {
        return 0;
    }

    protected double calculateCosts(double basicPrice, int includedTime, double pricePerExtraDay, int rentalLength) {
        double price = basicPrice;
        if (rentalLength > includedTime)
            price += (rentalLength - includedTime) * pricePerExtraDay;
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
