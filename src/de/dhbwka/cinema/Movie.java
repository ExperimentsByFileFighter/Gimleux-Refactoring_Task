package de.dhbwka.cinema;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private Price price;
    private final String title;

    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPrice(newpriceCode);
    }
    public int getPriceCode() {
        return price.getPriceCode();
    }

    public String getTitle (){
        return title;
    };

    public Price getPrice(){
        return price;
    }

    public void setPrice(int priceCode){
        price = Price.createPrice(priceCode);
    }

    int getFrequentRenterPoints(int rentalLength) {
        // add bonus for a two day new release rental
        return price.getFrequentRenterPoints(rentalLength);
    }

    double getCharge(int rentalLength){
        return price.getCharge(rentalLength);
    }
}