package com.ximo.refactoringinaction.first_chapter.domain;

import lombok.Data;

import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.CHILDREN;
import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.NEW_RELEASE;
import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.REGULAR;

/**
 * @author 朱文赵
 * @date 2018/1/8
 * @description
 */
@Data
public class Movie {

    private String title;
    private BasePrice price;

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasesPrice();
                break;
            default:
                throw new IllegalArgumentException("参数不正确");
        }
    }


    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (this.getPriceCode() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }



}
