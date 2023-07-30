
public class Square extends Rectangle implements TwoDimensionalShape {

    protected static String textDescription = "a square";

    // parameterized constructor for Square
    // pre: passed value for side length is a positive integer
    Square(int side) {
        super(side, side);
        setName("Square");
        setDescription("A quadrilateral with four right angles and four equal sides");
    }

    // pre: passed value is a positive integer
    // post: both height and width (i.e. square side length) are modified to passed value
    private void setSide(int side) {
    	assert side >= 1;
    	this.height = side; 
    	this.width =  side;
    }

    //post: returns 0 if width and height are unequal, height otherwise, for the purpose of cube face test
    public int getSide() {
    	if(width == height)
    		return height;
    	else
    		return 0;
    }
    
    //post: returns a string with both a Rectangle version name and description
    public String getDescription() {
    	Rectangle temp = new Rectangle(1, 2);
    	return temp.getDescription() + "\n" + super.getDescription();
    }


}
