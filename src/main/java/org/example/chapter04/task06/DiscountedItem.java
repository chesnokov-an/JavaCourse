package org.example.chapter04.task06;

import java.util.Objects;

public class DiscountedItem extends Item{
    private double discount;

    public DiscountedItem(String description, double price, double discount){
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject){
        if (otherObject instanceof Item && !(otherObject instanceof DiscountedItem)){
            return super.equals(otherObject);
        }
        if (!(otherObject instanceof DiscountedItem)) return false;
        DiscountedItem other = (DiscountedItem)otherObject;
        return super.equals(other) && discount == other.discount;
    }

    @Override public int hashCode(){
        return Objects.hash(super.hashCode(), discount);
    }

    static void main(){
        Item x = new Item("widget", 10);
        DiscountedItem y = new DiscountedItem("widget", 10, 5);
        DiscountedItem z = new DiscountedItem("widget", 10, 20);

        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        System.out.println(y.equals(z));
    }
}

