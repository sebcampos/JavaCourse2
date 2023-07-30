
interface TwoDimensionalShape {
	
	// post: returns the perimeter of the 2D shape
    double calculatePerimeter();
    
    // post: returns whether the calling Shape's perimeter is less than or equal to that of the passed Shape
    boolean perimeterCanFitInside(Shape shape);
}
