import java.util.*;

public class ShapeTester {

    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(3,4);
        Rectangle rectangle2 = new Rectangle(4,3);
        Rectangle rectangle3 = new Rectangle(5,6);
        Square square1 = new Square(2);
        Square square2 = new Square(4);
        Square square3 = new Square(4);
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle(5);
        Cylinder cylinder1 = new Cylinder(3, 5);
        Cylinder cylinder2 = new Cylinder(4, 6);
        Cylinder cylinder3 = new Cylinder(6, 4);
        Cube cube1 = new Cube(2);
        Cube cube2 = new Cube(3);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(rectangle1);
        shapeList.add(rectangle2);
        shapeList.add(rectangle3);
        shapeList.add(square1);
        shapeList.add(square2);
        shapeList.add(square3);
        shapeList.add(circle1);
        shapeList.add(circle2);
        shapeList.add(cylinder1);
        shapeList.add(cylinder2);
        shapeList.add(cylinder3);
        shapeList.add(cube1);
        shapeList.add(cube2);

        System.out.println("*****PRINTING OUT THE TEXT REPRESENTATION, DESCRIPTION, AREA, AND PERIMETER/VOLUME OF EACH SHAPE");
        for(Shape shape : shapeList) {
            System.out.println(shape);
            System.out.println(shape.getDescription());
            System.out.println("\tArea: " + shape.calculateArea());

            // PRINTING THE PERIMETER OF TWO-DIMENSIONAL SHAPES
            if (shape instanceof TwoDimensionalShape)
            {
                System.out.println("\tPerimeter: " + ((TwoDimensionalShape) shape).calculatePerimeter() + "\n");
            }

            // PRINTING THE VOLUME OF THREE-DIMENSIONAL SHAPES
            else if (shape instanceof ThreeDimensionalShape)
            {
                System.out.println("\tVolume: " + ((ThreeDimensionalShape) shape).calculateVolume() + "\n");
            }

        }


        System.out.println("\n*****PRINTING ALL EQUAL, NON-ALIAS SHAPES");
        for(Shape firstShape : shapeList) {
            for(Shape secondShape : shapeList) {
                // TESTING IF THE TWO SHAPES ARE EQUAL (BUT NOT ALIASES!) PRINT THE SHAPES
                if (firstShape.equals(secondShape))
                {
                    System.out.println("Equal shapes found:");
                    System.out.println("\t" + firstShape);
                    System.out.println("\t" + secondShape);

                }
            }
        }

        System.out.println("\n*****PRINTING ALL CUBE/SQUARE  or Cylinder/Circle COMBINATIONS WHERE THE SQUARE IS A SIDE FOR THE CUBE");
        for(Shape firstShape : shapeList) {
            for(Shape secondShape : shapeList) {
                // TESTING THE isTopOrBottom METHOD FOR SQUARE/CUBE COMBINATIONS. PRINT ANY MATCHES FOUND.
                if (firstShape instanceof ThreeDimensionalShape && ((ThreeDimensionalShape)firstShape).isTopOrBottom(secondShape))
                {
                    if (firstShape instanceof Cube)
                    {
                        System.out.println("Square-Cube Match Found");
                        System.out.println("\tSquare: " + secondShape);
                        System.out.println("\tCube: " + firstShape + "\n");
                    }
                    else if (firstShape instanceof Cylinder)
                    {
                        System.out.println("Circle-Cylinder Match Found");
                        System.out.println("\tCircle: " + secondShape);
                        System.out.println("\tCylinder: " + firstShape + "\n");
                    }
                }
            }
        }

        System.out.println("\n*****PRINTING ALL COMBINATIONS OF TWO-DIMENSIONAL SHAPES WHOSE PERIMETERS CAN FIT INSIDE ANOTHER");
        for(Shape firstShape : shapeList) {
            for(Shape secondShape : shapeList) {
                // EXTRA CREDIT: TEST THE perimeterCanFitInside METHOD FOR PAIRS OF TWO DIMENSIONAL SHAPES. PRINT ANY SHAPES THAT NEST.
                if (secondShape.perimeterCanFitInside(firstShape))
                {
                    System.out.println("Nested Shapes found: ");
                    System.out.println("\tOuter: " + firstShape);
                    System.out.println("\tInner: " + secondShape);
                    System.out.println();

                }
            }
        }

    }

}
