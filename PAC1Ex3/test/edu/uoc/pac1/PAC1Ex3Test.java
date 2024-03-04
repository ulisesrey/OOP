package edu.uoc.pac1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PAC1Ex3Test {

    @Test
    public void testIsValidSeat() {
        assertFalse(PAC1Ex3.isValidSeat(-1, 0));
        assertTrue(PAC1Ex3.isValidSeat(0, 0));
        assertTrue(PAC1Ex3.isValidSeat(0, 13));
        assertFalse(PAC1Ex3.isValidSeat(0, 14));
        assertFalse(PAC1Ex3.isValidSeat(14, 0));
        assertTrue(PAC1Ex3.isValidSeat(13, 0));
        assertTrue(PAC1Ex3.isValidSeat(13, 13));
    }

    @Test
    public void testCalculatePriceInvalidSeat() {
        int[][] seats = new int[][]{{0, 1}};
        assertEquals(-1.0, PAC1Ex3.calculatePrice(seats));

        seats = new int[][]{{1, 1}, {1, 2}, {1, 15}};
        assertEquals(-1.0, PAC1Ex3.calculatePrice(seats));
    }

    @Test
    public void testCalculatePrice() {
        int[][] seats = new int[][]{};
        assertEquals(0.0, PAC1Ex3.calculatePrice(seats));

        seats = new int[][]{{1, 1}};
        assertEquals(4.0, PAC1Ex3.calculatePrice(seats));

        seats = new int[][]{{1, 1}, {1, 2}, {1, 3}};
        assertEquals(12.75, PAC1Ex3.calculatePrice(seats));

        seats = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 11}, {12, 12}, {13, 13}, {14, 14}};
        assertEquals(77.0, PAC1Ex3.calculatePrice(seats));
    }

    @Test
    public void testCalculateDiscount() {
        assertEquals(0.0, PAC1Ex3.calculateDiscount(0.0, 0));
        assertEquals(0.0, PAC1Ex3.calculateDiscount(8.5, 2));
        assertEquals(0.64, PAC1Ex3.calculateDiscount(12.75, 3));
        assertEquals(2.28, PAC1Ex3.calculateDiscount(22.75, 5));
        assertEquals(6.7, PAC1Ex3.calculateDiscount(67.0, 8));
        assertEquals(7.1, PAC1Ex3.calculateDiscount(71.0, 9));
        assertEquals(12.64, PAC1Ex3.calculateDiscount(84.25, 11));
        assertEquals(13.73, PAC1Ex3.calculateDiscount(91.5, 16));
    }

    @Test
    public void testCalculateTotalPriceInvalidSeat() {
        int[][] seats = new int[][]{{0, 1}};
        assertEquals(-1.0, PAC1Ex3.calculateTotalPrice(seats, 1));

        seats = new int[][]{{1, 1}, {1, 2}, {1, 15}};
        assertEquals(-1.0, PAC1Ex3.calculateTotalPrice(seats, 1));
    }

    @Test
    public void testCalculateTotalPrice() {
        int[][] seats = new int[][]{{1, 1}, {1, 2}, {1, 3}};
        assertEquals(13.32, PAC1Ex3.calculateTotalPrice(seats, 2));

        seats = new int[][]{{1, 1}, {1, 2}, {1, 3}};
        assertEquals(14.53, PAC1Ex3.calculateTotalPrice(seats, 3));

        seats = new int[][]{{1, 1}, {1, 2}, {1, 3}};
        assertEquals(16.95, PAC1Ex3.calculateTotalPrice(seats, 4));

        seats = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 11}, {12, 12}, {13, 13}, {14, 14}};
        assertEquals(117.81, PAC1Ex3.calculateTotalPrice(seats, 5));

        seats = new int[][]{{7, 6}, {7, 7}, {7, 8}, {7, 9}, {7, 10}, {8, 6}, {8, 7}, {8, 8}};
        assertEquals(123.17, PAC1Ex3.calculateTotalPrice(seats, 6));
    }

}
