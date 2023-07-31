
public class Rectangle  extends Shape implements TwoDimensionalShape{
    protected static String textDescription = "a rectangle";
    protected int width;
    protected int height;

    // paramerized constructor for Rectangle
    // both passed values for width and height are positive integers
    Rectangle(int width, int height) {
    	setBase(width);
    	setHeight(height);
    	setName("Rectangle");
    	setDescription("A quadrilateral with four right angles");
    }

    //post: returns width of rectangle
    public int getBase(){
        return width;
    }

    //post: returns height of rectangle
    public int getHeight()
    {
        return height;
    }

    //pre: passed value is a positive integer
    //post: width is modified
    public void setBase(int width) {
        assert width >= 1;
        assert name.equals("Rectangle"); // squares must use setSize()
        this.width = width;
    }
    
    //pre: passed value is a positive integer
    //post: height is modified
    public void setHeight(int height) {
        assert height >= 1;
        assert name.equals("Rectangle"); // squares must use setSize()
        this.height = height;
    }

    @Override
    //post: returns area of rectangle
    public double calculateArea() {return width * height;}

    @Override
    //post: returns perimeter of rectangle
    public double calculatePerimeter()
    {
        return (width * 2) + (height * 2);
    }


    @Override
    // post: returns a string containing the name of the shape along with dimensional properties, tab-separated
    public String toString()
    {
        String ret = super.toString();
        if(name.equals("Rectangle"))
        	ret += "\tWidth: " + width + "\tHeight: " + height;
        else
        	ret += "\tSide length: " + getSide();
        return ret;
    }
}
