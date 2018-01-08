package com.ximo.refactoringinaction.first_chapter.domain;

import lombok.Data;

/**
 * @author 朱文赵
 * @date 2018/1/8
 * @description
 */
@Data
public class Movie {

    private String title;
    private int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }


}
