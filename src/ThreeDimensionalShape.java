
interface ThreeDimensionalShape  {
	
	// returns positive double representing volume of 3D Shape
    double calculateVolume();
    
    // returns whether the passed Shape may be one of the flat faces of the calling 3D object
    // pre: passed Shape is 2D
    boolean isTopOrBottom(Shape threeDimensionalShape);
}