
public class Cube extends Shape implements ThreeDimensionalShape {

    private int side;

    // parameterized constructor for Cube
    // pre: passed value for side length is a positive integer
    Cube(int side) {
        this.side = side;
        setName("Cube");
        setDescription("A three-dimensional solid object bounded by six square faces with three meeting at each vertex");
    }

    // returns the side length of the Cube
    public int getSide() {return side;}
 
    // pre: passed value for side length is a positive integer
    // post: modifies side length
    public void setSide(int side) {
    	assert side >= 1;
    	this.side = side;
    }
    
 // post: returns a string containing the name of the shape along with dimensional properties, tab-separated
    @Override
    public String toString()
    {
        return super.toString() + "\tSide Length: " + side;
    }

    // post: returns the SURFACE AREA of the Cube object, 6x^2
    @Override
    public double calculateArea() {
    	return 6 * side * side;
    }

    // post: returns the volume of the cube object, x^3
    @Override
    public double calculateVolume(){
    	return side * side * side;
    }

    // pre: passed Shape is 2D
    // post: returns a boolean whether the passed Shape may be one of the flat faces of the calling 3D object
    // post: returns true if the passed object of type Square and has the same side length as the calling Cube
    @Override
    public boolean isTopOrBottom(Shape otherSquare)
    {
        return otherSquare.getSide() == side; // getSide is defined for this class and Square exclusively
        // attempting to compare with a Rectangle or any other Shape will result in getSide() returning 0.
    }
}