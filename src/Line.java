import java.util.List;

/**
 * @author Yair Cohen
 */
public class Line {
    private Point start;
    private Point end;
    // constructors

    /**
     * the method is constructor for line.
     *
     * @param start point.
     * @param end   point .
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    // constructors.

    /**
     * the method is constructor for line.
     *
     * @param x1 value.
     * @param y1 value.
     * @param x2 value.
     * @param y2 value.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * the method return the length of the line.
     *
     * @return length of line
     */
    public double length() {
        double sum = ((start.getX() - end.getX()) * (start.getX() - end.getX()))
                + ((start.getY() - end.getY()) * (start.getY() - end.getY()));
        double rootOfSum = Math.sqrt(sum);
        return rootOfSum;
    }

    /**
     * the method returns the middle point of the line.
     *
     * @return point middle of line.
     */
    public Point middle() {
        double mx, my;
        mx = (start.getX() + end.getX()) / 2;
        my = (start.getY() + end.getY()) / 2;
        return new Point(mx, my);
    }

    /**
     * the method returns start point of the line.
     *
     * @return point start of line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the method returns end point of the line.
     *
     * @return point end of line
     */
    public Point end() {
        return this.end;
    }

    /**
     * the method check if the lines are intersect.
     *
     * @param other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) == null) {
            return false;
        }
        return true;

    }

    /**
     * the method check the intersection point.
     *
     * @param other line
     * @return Returns the intersection point if the lines intersect,
     * // and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double slope1, slope2;
        double pointx = 0, pointy = 0;
        double b1 = 0, b2 = 0;
        Line tempThis = new Line(this.start(), this.end());
        Line tempOther = new Line(other.start(), other.end());

        //define the left point of the line to start point
        if (tempOther.start.getX() > tempOther.end.getX()) {
            Point temp;
            temp = new Point(tempOther.start.getX(), tempOther.start.getY());
            tempOther.start = tempOther.end;
            tempOther.end = temp;
        }
        //define the left point of the line to start point
        if (tempThis.start.getX() > tempThis.end.getX()) {
            Point temp;
            temp = new Point(tempThis.start.getX(), tempThis.start.getY());
            tempThis.start = tempThis.end;
            tempThis.end = temp;
        }
        slope1 = (tempThis.start.getY() - tempThis.end.getY()) / (tempThis.start.getX() - tempThis.end.getX());
        slope2 = (tempOther.start.getY() - tempOther.end.getY()) / (tempOther.start.getX() - tempOther.end.getX());
        b1 = tempThis.start.getY() - (slope1 * tempThis.start.getX());
        b2 = tempOther.start.getY() - (slope2 * tempOther.start.getX());

        if (tempOther.start.getX() == tempOther.end.getX()) {
            pointx = tempOther.start.getX();
            if (((tempThis.start.getX() <= pointx)
                    && (tempThis.end.getX() >= pointx))
                    && ((((tempThis.end.getY() >= tempOther.start.getY())
                    && (tempThis.end.getY() <= tempOther.end.getY())))
                    || ((tempThis.start.getY() >= tempOther.start.getY())
                    && (tempThis.start.getY() <= tempOther.end.getY())))) {
                pointy = slope1 * tempOther.start.getX() + b1;
                return new Point(tempOther.start.getX(), pointy);
            } else {
                return null;
            }
        }
        if ((tempThis.start.getX() == tempThis.end.getX())) {
            if (((tempOther.start.getX() <= tempThis.start.getX())
                    && (tempOther.end.getX() >= tempThis.start.getX()))
                    && ((((tempOther.end.getY() >= tempThis.start.getY())
                    && (tempOther.end.getY() <= tempThis.end.getY())))
                    || ((tempOther.start.getY() >= tempThis.start.getY())
                    && (tempOther.start.getY() <= tempThis.end.getY())))) {
                pointy = slope2 * tempThis.start.getX() + b2;
                return new Point(tempThis.start.getX(), pointy);
            } else {
                return null;
            }
        }

        if ((slope1 == slope2)
                && (b1 == b2)) {
            if (((tempOther.start.getX() >= tempThis.start.getX())
                    && (tempOther.start.getX() <= tempThis.end.getX()))
                    && ((tempOther.start.getY() >= tempThis.start.getY())
                    && (tempOther.start.getY() <= tempThis.end.getY()))) {
                return tempOther.start();
            }
            if (((((tempOther.start.getY() >= tempThis.start.getY())
                    && (tempOther.start.getY() <= tempThis.end.getY()))))) {
                return tempOther.end();
            } else {
                return null;
            }
        }

        //one of the line is horizontal line
        if ((slope1 == 0)
                || (slope2 == 0)) {
            if (slope1 == 0) {
                pointy = tempThis.start.getY();
                if (((tempOther.start.getY() <= pointy)
                        && (tempOther.end.getY() >= pointy))
                        && ((((tempOther.end.getX() >= tempThis.start.getX())
                        && (tempOther.end.getX() <= tempThis.end.getX())))
                        || ((tempOther.start.getX() >= tempThis.start.getX())
                        && (tempOther.start.getX() <= tempThis.end.getX())))) {
                    pointx = (pointy - b2) / slope2;
                    return new Point(pointx, pointy);
                } else {
                    return null;
                }
            }
            if (slope2 == 0) {
                pointy = tempOther.start.getY();
                if ((((tempThis.start.getY() <= pointy)
                        && (tempThis.end.getY() >= pointy))
                        || ((tempThis.start.getY() >= pointy)
                        && (tempThis.end.getY() <= pointy)))
                        && ((((tempThis.end.getX() >= tempOther.start.getX())
                        && (tempThis.end.getX() <= tempOther.end.getX())))
                        || ((tempThis.start.getX() >= tempOther.start.getX())
                        && (tempThis.start.getX() <= tempOther.end.getX())))) {
                    pointx = (pointy - b1) / slope1;
                    return new Point(pointx, pointy);
                } else {
                    return null;
                }
            }

            //compute the intresection point
        } else {
            pointx = (b2 - b1) / (slope1 - slope2);

            //range of x
            if ((pointx >= tempThis.start.getX())
                    && (pointx >= tempOther.start.getX())
                    && (pointx <= tempThis.end.getX())
                    && (pointx <= tempOther.end.getX())) {
                pointy = (slope1 * pointx) + b1;

                //range of y
                if ((((pointy <= tempThis.start.getY())
                        && (pointy >= tempThis.end.getY()))
                        || ((pointy >= tempThis.start.getY())
                        && (pointy <= tempThis.end.getY())))
                        && (((pointy <= tempOther.start.getY())
                        && (pointy >= tempOther.end.getY()))
                        || ((pointy >= tempOther.start.getY())
                        && (pointy <= tempOther.end.getY())))) {
                    return new Point(pointx, pointy);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }


    /**
     * the method check if lines are equal.
     *
     * @param other line
     * @return return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return ((this.start.getX() == other.start.getX()) && (this.start.getY() == other.start.getY())
                && (this.end.getX() == other.end.getX()) && (this.end.getY() == other.end.getY()));

    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the.
     * start of the line.
     *
     * @param rect the rectangle of the cllision.
     * @return the closeet intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(this);
        if (points.size() == 0) {
            return null;
        }
        if (points.size() == 1) {
            return points.get(0);
        } else {
            Point minP = points.get(0);
            for (Point temp : points) {
                if (temp.distance(this.start()) < minP.distance(this.start())) {
                    minP = temp;
                }
            }
            return minP;
        }
    }
}