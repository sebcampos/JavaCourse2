public class Cube extends Shape implements ThreeDimensionalShape {

    // cube `has a` square
    private final Square face;

    /**
     * parameterized constructor for Cube
     * @param side passed value for side length is a positive integer
     */
    Cube(int side) {
        face = new Square(side);
        setName("Cube");
        setDescription("A three-dimensional solid object bounded by six square faces with three meeting at each vertex");
    }


    /**
     * @return the SURFACE AREA of the Cube object, 6x^2
     */
    @Override
    protected double area()
    {
        return 6 * face.getSide() * face.getSide();
    }

    /**
     * @return the volume of the cube object, x^3
     */
    @Override
    public double calculateVolume()
    {
        return Square.calculateAreaOfFourSidedShape(face.getSide(), face.getSide()) * face.getSide();
    }

    /**
     * returns a boolean whether the passed Square may be one of the flat faces of the
     * calling 3D Cube object
     * @param otherSquare passed Shape is 2D Square
     * @return boolean
     */
    @Override
    public boolean isTopOrBottom(Shape otherSquare)
    {
        return otherSquare.equals(face);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }
        if (!(o instanceof Cube otherCube)) {
            return false;
        }

        if (!(face.getSide() == otherCube.face.getSide())) {
            return false;
        }
        return getDescription().equalsIgnoreCase(otherCube.getDescription());
    }

    /**
     * @return a string containing the name of the shape along with dimensional properties, tab-separated
     */
    @Override
    public String toString()
    {
        return super.toString() + " Side Length: " + face.getSide();
    }

}
