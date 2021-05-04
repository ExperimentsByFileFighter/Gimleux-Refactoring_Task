package de.dhbwka.cinema;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    public String getTitle (){
        return title;
    };

    double getCharge(int rentalLength) {
        double price;
        switch (getPriceCode()) {
            case REGULAR:
                price = calculateAmount(2, 2,1.5, rentalLength);
                break;
            case NEW_RELEASE:
                price = calculateAmount(0, 0,3, rentalLength);
                break;
            case CHILDRENS:
                price = calculateAmount(1.5, 3, 1.5, rentalLength);
                break;
            default:
                price = 0;
        }
        return price;
    }

    private double calculateAmount(double basicPrice, int includedPeriod, double pricePerExtraDay, int rentalLength) {
        double price = basicPrice;
        if (rentalLength > includedPeriod)
            price += (rentalLength - includedPeriod) * pricePerExtraDay;
        return price;
    }

    int getFrequentRenterPoints(int rentalLength) {
        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE) && rentalLength > 1)
            return 2;
        return 1;
    }
}