public class Cylinder extends Shape implements ThreeDimensionalShape
{
    private int radius;
    private int height;

    // `has a` relationship
    private final Circle topOrBottomCircle;

    /**
     * parameterized constructor for Cylinder
     * both passed values for radius and height are positive integers
     * @param radius int value
     * @param height int value
     */
    Cylinder(int radius, int height)
    {
        topOrBottomCircle = new Circle(radius);
        setRadiusAndHeight(radius, height);
        setName("Cylinder");
        setDescription("A solid geometric figure with straight parallel sides and a circular or oval cross section");
    }

    /**
     * @return radius of Cylinder
     */
    private int getRadius() {return radius;}


    /**
     * @return height of Cylinder
     */
    private int getHeight() {return height;}


    /**
     * Returns A circle which could represent the top
     * or bottom of the Cylinder
     * @return Instance of TwoDimensional Circle
     */
    private Circle getTopOrBottomCircle() {return topOrBottomCircle;}



    @Override
    public String toString()
    {
        return super.toString() + " Radius: " + getRadius() + " Height: " + getHeight();
    }

    /**
     * Sets the radius and height of the Cylinder
     * @param radius int
     * @param height int
     */
    private void setRadiusAndHeight(int radius, int height)
    {
        assert ((radius > 0) && (height > 0));
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculates the Surface area of the Cylinder
     * @return double, Surface area of the Cylinder
     */
    @Override
    public double area()
    {
        double areaOfCircle =  getTopOrBottomCircle().area();
        return 2 * Math.PI * radius * height + (2 * areaOfCircle);
    }

    /**
     * Leverages the Circle Calculate Area Of A Circle method
     * to calculate the volume of a Cylinder
     * @return double, Volume of the Cylinder
     */
    @Override
    public double calculateVolume()
    {
        return Circle.calculateAreaOfACircle(radius) * height;
    }

    /***
     * @param otherCircle passed Shape is 2D Circle
     * @return  a boolean whether the passed Shape may be one of the flat faces of the calling 3D object
     */
    @Override
    public boolean isTopOrBottom(Shape otherCircle)
    {
        return otherCircle.equals(getTopOrBottomCircle());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Cylinder otherCylinder)) {
            return false;
        }

        if (!(radius == otherCylinder.getRadius())) {
            return false;
        }
        return getDescription().equalsIgnoreCase(otherCylinder.getDescription());
    }

}
