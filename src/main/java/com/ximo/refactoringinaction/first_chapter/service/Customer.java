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
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result.concat("\t" + each.getMovie().getTitle() + "\t")
            .concat(String.valueOf(each.getCharge()));
        }
        result += "Amount owed is ".concat(String.valueOf(getTotalCharge()))
                .concat("You earned ").concat(String.valueOf(getTotalFrequentRenterPoints()))
                .concat("frequentRenterPoints");
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

}
