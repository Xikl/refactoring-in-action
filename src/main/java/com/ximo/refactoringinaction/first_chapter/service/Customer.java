package com.ximo.refactoringinaction.first_chapter.service;

import com.ximo.refactoringinaction.first_chapter.domain.Rental;
import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;
import java.util.Vector;

import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.*;

/**
 * @author 朱文赵
 * @date 2018/1/8
 * @description
 */
public class Customer {

    @Getter @Setter
    private String name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRentals(Rental rental) {
        _rentals.addElement(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = each.getCharge();
            frequentRenterPoints ++;
            if (each.getMovie().getPriceCode() == NEW_RELEASE &&
                    each.getDayRented() > 1) {
                frequentRenterPoints ++;
            }
            result.concat("\t" + each.getMovie().getTitle() + "\t")
            .concat(String.valueOf(thisAmount));
            totalAmount += thisAmount;
        }
        result += "Amount owed is ".concat(String.valueOf(totalAmount))
                .concat("You earned ").concat(String.valueOf(frequentRenterPoints))
                .concat("frequentRenterPoints");
        return result;
    }

}
