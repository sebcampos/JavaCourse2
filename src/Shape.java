
public class Shape {

    protected String name;
    protected String textDescription;

    // returns a String containing the shape's description
    public String getDescription() {
    	return getName() + ": " + textDescription;
    }
    
    // returns a String containing the shape's name
    public String getName() {return name;}

    // only executed as part of derived class's toString methods
    // returns a String containing the shape's name
    @Override
    public String toString()
    {
        return name;
    }

    // post: shape's description is modified according to passed string
    // only used in subclass constructors
    protected void setDescription(String description)
    {
        textDescription = description;
    }

    // post: shape's name is modified according to passed string
    // only used in subclass constructors
    protected void setName(String name)
    {
        this.name = name;
    }
    
    // dummy side length method used for Shapes that are not Squares
    public int getSide() {return 0;}
    
    // dummy radius method used for Shapes that are not circles or cylinders
    public int getRadius() {return 0;}
    
    // dummy perimeter method used for 3D shapes
    public double calculatePerimeter() {return 0;}

    // dummy area or surface area method, never executed
    public double calculateArea() {return 0;}
    
    // dummy volume method used for 2D shapes
    public double calculateVolume() {return 0;}
    
    // returns a boolean whether calling Shape and passed Shape are "equal"
    // pre: passed shape is not null
    public boolean equals(Shape other) {
    	double epsilion = 0.00001; 
    	// if any of the four aspects (radius, perimeter, area, volume) differ by more than this much,
    	// the shapes are unequal.
    	if(Math.abs(getRadius() - other.getRadius()) > epsilion)
    		return false; 
    		// getResius is only defined for circle and cylinder, so comparisons between a circle/cylinder and a non-circle/cylinder
    		// will result in the shapes being considered unequal.
    	if(Math.abs(calculatePerimeter() - other.calculatePerimeter()) > epsilion)
    		return false;
    		// calculatePerimater is only non-zero for 2D shapes, so any 3D will be considered unequal to any 2D shape.
    	    // however, comparing two 3D shapes will result in 0 ~= 0, meaning equality is still possible.
    	if(Math.abs(calculateArea() - other.calculateArea()) > epsilion)
    		return false;
    	if(Math.abs(calculateVolume() - other.calculateVolume()) > epsilion)
    		return false;
    		// calculateVolume is only non-zero for 3D shapes, so any 2D will be considered unequal to any 3D shape.
    		// however, comparing two 2D shapes will result in 0 ~= 0, meaning equality is still possible.
    	// if all of the above are equal or very close to equal, the shapes are considered equal.
    	return true;
    }
    
    // returns whether the calling Shape's perimeter is nonzero but less than or equal to the passed Shape's perimeter
    // if so, the calling Shape can supposedly fit inside the passed Shape, and true is returned
    // pre: both the calling and passed Shape objects implement TwoDimensionalObject
    public boolean perimeterCanFitInside(Shape other) {
    	if(calculatePerimeter() < 0.0001)
    		return false; // in the case that a 3D shape is passed, this will be triggered and return false
    	if(this == other)
    		return false; // ignore nesting cases that compare to oneself
    	return calculatePerimeter() <= other.calculatePerimeter();
    }
    
}

