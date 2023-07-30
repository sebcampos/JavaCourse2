public class Rectangle extends Shape implements TwoDimensionalShape {
    private int base;
    private int height;

    /**
     * parametrized constructor for Rectangle
     * both passed values for width and height are positive integers
     * @param base width int
     * @param height height int
     */
    Rectangle(int base, int height) {
        setBaseAndHeight(base, height);
        setName("Rectangle");
        setDescription("A quadrilateral with four right angles");
    }

    /**
     * @return returns width / base of rectangle
     */
    public int getBase(){
        return base;
    }

    /**
     * @return returns height of rectangle
     */
    public int getHeight()
    {
        return height;
    }



    private void setBaseAndHeight(int base, int height) {
        assert base != height;
        setBase(base);
        setHeight(height);
    }

    /**
     * @param base passed value for base length is a positive integer
     */
    private void setBase(int base)
    {
        assert base >= 1;
        this.base = base;
    }

    /**
     * @param height passed value for base length is a positive integer
     */
    private void setHeight(int height)
    {
        assert height >= 1;
        this.height = height;
    }


    /**
     * Calculates the area of a four-sided shape, used in the Rectangle, Square, and
     * Cube classes
     * @param sideOne int value of base or height
     * @param sideTwo int value of base or height
     * @return double value representing area of the four-sided shape
     */
    public static double calculateAreaOfFourSidedShape(int sideOne, int sideTwo)
    {
        return sideOne * sideTwo;
    }


    @Override
    protected double area() {return calculateAreaOfFourSidedShape(base, height);}


    @Override
    public double calculatePerimeter()
    {
        return (base * 2) + (height * 2);
    }


    @Override
    public String toString()
    {
        return super.toString() + " Width: " + base + " Height: " + height;
    }

    // TODO Note that for the Rectangle class, the rectangle (3,4) should be considered the same as
    //  the rectangle (4,3)
    public boolean equals(Object o)
    {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Rectangle otherRectangle )) {
            return false;
        }

        if (!((this.getBase() == otherRectangle.getHeight()) || (this.base == otherRectangle.getBase())))
        {
            return false;
        }

        if (!((this.getHeight() == otherRectangle.getHeight()) || (this.getHeight() == otherRectangle.getBase())))
        {
            return false;
        }

        return getDescription().equalsIgnoreCase(otherRectangle.getDescription());
    }

}
