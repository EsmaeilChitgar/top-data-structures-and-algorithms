import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RectangleCounter {

    public static int countRectangles(Point[] points) {
        int count = 0;
        Set<Point> pointSet = new HashSet<>();

        // Add all points to a set for efficient lookup
        Collections.addAll(pointSet, points);

        // Iterate through pairs of distinct points
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];

                // Check if p1 and p2 form a diagonal of a potential rectangle
                if (p1.x != p2.x && p1.y != p2.y) {
                    Point p3 = new Point(p1.x, p2.y); // Create third point
                    Point p4 = new Point(p2.x, p1.y); // Create fourth point

                    // Check if all four points exist in the set
                    if (pointSet.contains(p3) && pointSet.contains(p4)) {
                        count++;
                    }
                }
            }
        }

        // Each rectangle is counted four times (for each pair of points)
        return count / 4;
    }

    public static void main(String[] args) {
        // Example usage
        Point[] points = {
                new Point(1, 1),
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
                new Point(2, 2),
                new Point(4, 4),
                new Point(4, 1),
                new Point(1, 4)
        };

        int rectangles = countRectangles(points);
        System.out.println("Number of rectangles: " + rectangles);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point other = (Point) obj;
            return (this.x == other.x && this.y==other.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
}
