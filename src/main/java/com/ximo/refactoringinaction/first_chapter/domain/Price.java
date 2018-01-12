package com.ximo.refactoringinaction.first_chapter.domain;

import static com.ximo.refactoringinaction.first_chapter.constant.MovieConstatnt.*;

/**
 * @author 朱文赵
 * @date 2018/1/12 18:45
 * @description
 */
abstract class BasePrice {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class ChildrenPrice extends BasePrice{

    @Override
    int getPriceCode() {
        return CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result = (daysRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasesPrice extends BasePrice{

    @Override
    int getPriceCode() {
        return NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

class RegularPrice extends BasePrice{

    @Override
    int getPriceCode() {
        return REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}