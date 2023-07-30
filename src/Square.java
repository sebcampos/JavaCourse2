public class Square extends Rectangle implements TwoDimensionalShape {

    Square(int side) {
        super(side, side);
        setName("Square");
        setDescription("A quadrilateral with four equal sides and four equal angles");
    }

    public int getSide() {return getBase();}


    @Override
    protected double area() {return calculateAreaOfFourSidedShape(getSide(), getSide());}


    @Override
    public String toString()
    {
        return getName() + " Side Length: " + getBase();
    }

    @Override
    public double calculatePerimeter()
    {
        return getBase() * 4;
    }


    @Override
    public boolean perimeterCanFitInside(Shape shape)
    {
        // todo modify to only compare perimeter
        if (shape instanceof Circle)
        {
            return calculateHypotenuse(getBase(), getBase()) < ((Circle) shape).getRadius() * 2;
        }
        else if (shape instanceof Square)
        {
            return area() < shape.area();
        }
        else if (shape instanceof Rectangle)
        {
            return area() < shape.area();
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean equals(Object o)
    {

        if (o == this) {
            return false;
        }


        if (!(o instanceof Square otherSquare )) {
            return false;
        }

        if (!(getBase() == otherSquare.getSide()))
        {
            return false;
        }
        return getDescription().equalsIgnoreCase(otherSquare.getDescription());
    }
}

