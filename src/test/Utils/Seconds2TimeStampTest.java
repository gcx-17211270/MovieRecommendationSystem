package utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class Seconds2TimeStampTest {
    @Test
    public void test() {
        System.out.println(Seconds2TimeStamp.int2time(1242290862));
        Date date = new Date(1242290862 * 1000 * 1000);
        System.out.println(date);
    }
}