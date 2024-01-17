package com.kraftechnologie.tests.day20_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Demo {

    @DataProvider
    public Object[][] tvAndRating() {
        String[][] data = {
                {"Chernoybl", "9"},
                {"Breaking Bad", "10"},
                {"Prison Break", "10"},
                {"Lost", "9"},
                {"Fringe", "9"},
                {"Person of Interest", "9"},
                {"La Casa de Papel", "8"},
                {"Game of Thrones", "9"}
        };
        return data;
    }

    @Test(dataProvider = "tvAndRating")
    public void testTvShows(String tvShow, String rating) {
        System.out.println("Tv Show"+ tvShow+" has rating "+rating);
    }
}
