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
        return movie.getCharge(getDayRented());
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(getDayRented());
    }
}
