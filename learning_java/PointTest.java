public class PointTest {
    public static void main(String[] args) {
        // Define and initialize points
        Point lowerLeft = new Point();
        Point upperRight = new Point();
        Point middlePoint = new Point();

        // Set coordinates for lowerLeft
        lowerLeft.x = 0.0;
        lowerLeft.y = 0.0;

        // Set coordinates for upperRight
        upperRight.x = 1280.0;
        upperRight.y = 1024.0;

        // Calculate middle point
        middlePoint.x = (lowerLeft.x + upperRight.x) / 2;
        middlePoint.y = (lowerLeft.y + upperRight.y) / 2;

        // Output the middle point
        System.out.println("Middle point is at (" + middlePoint.x + ", " + middlePoint.y + ")");

        // Calculate the distance between lowerLeft and upperRight
        double distance = lowerLeft.distance(upperRight);

        // Output the distance
        System.out.println("Euclidean distance is " + distance);

    }
}

class Point {
    public double x, y;
    public void clear() {
        x = 0.0;
        y = 0.0;
    }
    public double distance(Point that) {
        double xdiff = x - that.x;
        double ydiff = y - that.y;
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }

}
