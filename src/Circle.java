
public class Circle extends Shape implements TwoDimensionalShape {

    private int radius;

    // parameterized constructor for Circle
    // pre: passed value for radius is a positive integer
    Circle(int radius)
    {
        setRadius(radius);
        setName("Circle");
        setDescription("A closed plane curve every point of which is equidistant from a fixed point within the curve");
    }

    // post: returns the radius of the Circle
    public int getRadius() {return radius;}
    
    // pre: passed value is a positive integer
    // post: radius is modified to adjusted value
    public void setRadius(int radius) {
    	assert radius >= 1;
    	this.radius = radius;
    }

    // post: returns the area of the Circle object, pi r-squared
    @Override
    public double calculateArea() {
    	return Math.PI * radius * radius;
    }

    // post: returns a string containing the name of the shape along with dimensional properties, tab-separated
    @Override
    public String toString()
    {
        return super.toString() + "\tRadius: " + radius;
    }

    // post: returns the perimeter of the Circle object, 2-pi-r
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    

}