interface TwoDimensionalShape {
    double calculatePerimeter();

    default boolean perimeterCanFitInside(Shape shape)
    {
        assert (shape instanceof TwoDimensionalShape);
        return this.calculatePerimeter() < ((TwoDimensionalShape)shape).calculatePerimeter();
    }
}
