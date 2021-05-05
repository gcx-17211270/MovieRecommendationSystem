package controller;

import POJO.movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MostRatingsControllerTest {
    @Test
    public void testArrayList() {
        List<movie> res = new ArrayList<>();
        res.add(new movie(1, "sdflasdf", "dsafa"));
        res.add(new movie(2, "sdflasdf", "dsafa"));
        res.add(new movie(3, "sdflasdf", "dsafa"));
        System.out.println(res.toString());
    }
}