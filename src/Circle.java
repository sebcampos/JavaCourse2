public class Circle extends Shape implements TwoDimensionalShape {

    private int radius;

    /**
     * parameterized constructor for Circle
     * @param radius passed value for radius is a positive integer
     */
    Circle(int radius)
    {
        setRadius(radius);
        setName("Circle");
        setDescription("A closed plane curve every point of which is equidistant from a fixed point within the curve");
    }

    /**
     * @return the radius of the Circle
     */
    public int getRadius() {return radius;}

    /**
     * radius is modified to adjusted value
     * @param radius passed value is a positive integer
     */
    private void setRadius(int radius) {
        assert (radius <= 0);
        this.radius = radius;
    }


    /**
     * returns the area of the Circle object, pi r-squared
     * @param radius passed value is a positive integer
     * @return area of the Circle
     */
    public static double calculateAreaOfACircle(int radius)
    {
        return radius *  radius * Math.PI;
    }


    @Override
    protected double area() {return calculateAreaOfACircle(radius);}


    /**
     * @return a string containing the name of the shape along with dimensional properties, tab-separated
     */
    @Override
    public String toString()
    {
        return super.toString() + " Radius: " + radius;
    }

    /**
     * @return returns the perimeter of the Circle object, 2-pi-r
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this) {
            return false;
        }

        if (!(o instanceof Circle otherCircle)) {
            return false;
        }

        if (!(radius == otherCircle.getRadius()))
        {
            return false;
        }
        return getDescription().equalsIgnoreCase(otherCircle.getDescription());
    }

}
