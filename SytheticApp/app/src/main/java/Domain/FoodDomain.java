package Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private String pic;
    private String destription;
    private Double fee;
    private int numberInCart;

    public FoodDomain(String title, String pic, String destription, Double fee) {
        this.title = title;
        this.pic = pic;
        this.destription = destription;
        this.fee = fee;
    }

    public FoodDomain(String title, String pic, String destription, Double fee, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.destription = destription;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public String getDestription() {
        return destription;
    }

    public Double getFee() {
        return fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setDestription(String destription) {
        this.destription = destription;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
