package edu.uoc.pac1;

public class PAC1Ex3 {

    private static final double[] CINEMA_MULTIPLIER_PER_SESSION = { 1.0, 1.1, 1.2, 1.4, 1.8, 2.5 };
    private static final double[][] CINEMA_SEATS_PRICE = {
            { 4.00, 4.25, 4.50, 4.75, 5.00, 5.25, 5.50, 5.50, 5.25, 5.00, 4.75, 4.50, 4.25, 4.00 },
            { 4.25, 4.50, 4.75, 5.00, 5.25, 5.50, 5.75, 5.75, 5.50, 5.25, 5.00, 4.75, 4.50, 4.25 },
            { 4.50, 4.75, 5.00, 5.25, 5.50, 5.75, 6.00, 6.00, 5.75, 5.50, 5.25, 5.00, 4.75, 4.50 },
            { 4.75, 5.00, 5.25, 5.50, 5.75, 6.00, 6.25, 6.25, 6.00, 5.75, 5.50, 5.25, 5.00, 4.75 },
            { 5.00, 5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.50, 6.25, 6.00, 5.75, 5.50, 5.25, 5.00 },
            { 5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 6.75, 6.50, 6.25, 6.00, 5.75, 5.50, 5.25 },
            { 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 7.00, 7.00, 6.75, 6.50, 6.25, 6.00, 5.75, 5.50 },
            { 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 7.00, 7.00, 6.75, 6.50, 6.25, 6.00, 5.75, 5.50 },
            { 5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.75, 6.75, 6.50, 6.25, 6.00, 5.75, 5.50, 5.25 },
            { 5.00, 5.25, 5.50, 5.75, 6.00, 6.25, 6.50, 6.50, 6.25, 6.00, 5.75, 5.50, 5.25, 5.00 },
            { 4.75, 5.00, 5.25, 5.50, 5.75, 6.00, 6.25, 6.25, 6.00, 5.75, 5.50, 5.25, 5.00, 4.75 },
            { 4.50, 4.75, 5.00, 5.25, 5.50, 5.75, 6.00, 6.00, 5.75, 5.50, 5.25, 5.00, 4.75, 4.50 },
            { 4.25, 4.50, 4.75, 5.00, 5.25, 5.50, 5.75, 5.75, 5.50, 5.25, 5.00, 4.75, 4.50, 4.25 },
            { 4.00, 4.25, 4.50, 4.75, 5.00, 5.25, 5.50, 5.50, 5.25, 5.00, 4.75, 4.50, 4.25, 4.00 },
    };

    public static double twoDecimals(double number) {
        return Math.round(number * 100d) / 100d;
    }

    public static boolean isValidSeat(int x, int y) {
        // return false if x or y are out of range, return true otherwise
        if (x < 0 || x > 13 || y < 0 || y > 13) {
            return false;
        }
        else {
            return true;
        }
    }

    public static double calculatePrice(int[][] selectedSeats) {

        double total_price = 0;
        // loop through every seat
        for (int i = 0; i < selectedSeats.length; i++) {
            // check if seat is valid
            if (isValidSeat(selectedSeats[i][0], selectedSeats[i][1])) {
                // calculate price of seat and add it to total price
                total_price += CINEMA_SEATS_PRICE[selectedSeats[i][0]][selectedSeats[i][1]];
            }
            else {
                return -1;
            }
        }
        return twoDecimals(total_price);
    }

    public static double calculateDiscount(double totalPrice, int numberOfSeats) {
        //TODO
    }

    public static double calculateTotalPrice(int[][] selectedSeats, int session) {
        //TODO
    }

}
