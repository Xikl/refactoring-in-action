package com.ximo.refactoringinaction.first_chapter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.*;

/**
 * @author 朱文赵
 * @date 2018/1/8
 * @description
 */
@Data
@AllArgsConstructor
public class Rental {

    private Movie movie;
    private int dayRented;

    public double getCharge() {
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case REGULAR:
                result = 2;
                if (this.getDayRented() > 2) {
                    result += (this.getDayRented() - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += this.getDayRented() * 3;
                break;
            case CHILDRENS:
                result = 1.5;
                if (this.getDayRented() > 3) {
                    result = (this.getDayRented() - 3) * 1.5;
                }
                break;
            default:
                System.out.println("你好歹买点啥");
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == NEW_RELEASE &&
                getDayRented() > 1) {
            return 2;
        }
        return 1;
    }
}
