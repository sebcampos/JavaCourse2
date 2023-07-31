
public class Cylinder extends Shape implements ThreeDimensionalShape
{
    private int radius;
    private int height;

    // parameterized constructor for Cylinder
    // pre: both passed values for radius and height are positive integers
    Cylinder(int radius, int height)
    {
        setRadius(radius);
        setHeight(height);
        setName("Cylinder");
        setDescription("A solid geometric figure with straight parallel sides and a circular or oval cross section");
    }

    // post: returns radius of Cylinder
    public int getRadius() {return radius;}
    
    // post: returns height of Cylinder
    public int getHeight() {return height;}

    // post: returns a string containing the name of the shape along with dimensional properties, tab-separated
    @Override
    public String toString()
    {
        return super.toString() + "\tRadius: " + radius + "\tHeight: " + height;
    }

    // pre: passed value for radius is a positive integer
    // post: radius is modified according to passed value
    public void setRadius(int radius) {
        assert radius >= 1;
        this.radius = radius;
    }
    
    // pre: passed value for height is a positive integer
    // post: height is modified according to passed value
    public void setHeight(int height) {
        assert height >= 1;
        this.height = height;
    }

    // post: calculates and returns the SURFACE AREA of the cylinder
    @Override
    public double calculateArea()
    {
        double circleFaceArea = Math.PI * radius * radius;
        double circumfrence = 2 * Math.PI * radius;
        double shaftArea = circumfrence * height; 
        // the shaft is a rectangular face coiled around the cylinder
        return shaftArea + 2 * circleFaceArea; // cylinder has two circle faces
    }

    // post: calculates the volume of the cylinder
    @Override
    public double calculateVolume()
    {
        double baseArea = Math.PI * radius * radius;
    	return baseArea * height;
    }

    // pre: passed Shape is 2D
    // post: returns a boolean whether the passed Shape may be one of the flat faces of the calling 3D object
    @Override
    public boolean isTopOrBottom(Shape otherCircle)
    {
        Circle currentCircle = new Circle(radius);
        return otherCircle.equals(currentCircle);
    }

}