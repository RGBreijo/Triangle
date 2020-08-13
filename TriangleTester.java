/*=============================================================================
|     Source code:  TriangleTester.java Triangle.java
|
|     Assignment:   Program 2 Triangle
|
|     Course:       COP3337
|     Section:      U06
|
|
|         Language:     Java
|         Compile/Run:  javac TriangleTester.java  Triangle.java
|                       java TriangleTester
|
|  +-----------------------------------------------------------------------------
|
|    Description:   The program provides information about a specified triangle.
|
|                   The user is asked to input x- and y- coordinates for the three points of a triangle.
|
|                   The following formulas where used in the program
|
|                   Angle of point A: COS(A) = b^2 + c^2 - a^2 / 2bc
|                   Angle of point B: COS(B) = c^2 + a^2 - b^2 / 2ca
|                   Angle of point C: COS(C) = a^2 + b^2 - c^2 / 2ab
|
|                    Perimeter: a + b + c
|                    Area: sqr( p (p - a) (p - b) (p - c) )
|                          p = a + b + c / 2
|
|
|
|    Input:         The user is provides an x- and y- coordinates for the three Points of a triangle.
|
|
|    Output:        The program will display all three Points, the lengths of all three sides,
|                   the three angles at the corners, the perimeter and the area of the triangle,
|                   and whether the triangle is Acute, Obtuse, Isosceles or neither.
|
|
|    Process:      The program's steps are as follows
|
|                  1. The user is promoted to enter coordinates representing three points.
|                  2. The user coordinates are assigned to a point object.
|                  3. the desired information is computed and displayed.
|
|
|   Required Features Not Included: All required features are included.
|
|
|   Known Bugs: None; the program operates correctly.
|  *===========================================================================*/

import java.util.Scanner;  // To receive input from user


public class TriangleTester {


    public static void main(String[] args)
    {


        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 0.0;
        double y2 = 0.0;
        double x3 = 0.0;
        double y3 = 0.0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the x,y coordinates of three points in this order (x1,y1) (x2,y2) (x3,y3)");
        System.out.println("Separate each coordinate with a <return>: ");

        x1 = validateInput(input);
        y1 = validateInput(input);
        x2 = validateInput(input);
        y2 = validateInput(input);
        x3 = validateInput(input);
        y3 = validateInput(input);

        Triangle testTriangle = new Triangle(x1, y1, x2, y2, x3, y3);

        System.out.printf("\nPoint 1: (%.05f , %.05f)", x1, y1);
        System.out.printf("\nPoint 2: (%.05f , %.05f)", x2, y2);
        System.out.printf("\nPoint 3: (%.05f , %.05f)", x3, y3);

        System.out.printf("\n\nSide 1 Length: %.05f units", testTriangle.getPointALength());
        System.out.printf("\nSide 2 Length: %.05f units", testTriangle.getPointBLength());
        System.out.printf("\nSide 3 Length: %.05f units", testTriangle.getPointCLength());

        System.out.printf("\n\nAngle 1: %.0f degrees", testTriangle.getPointAAngle());
        System.out.printf("\nAngle 2: %.0f degrees", testTriangle.getPointBAngle());
        System.out.printf("\nAngle 3: %.0f degrees", testTriangle.getPointCAngle());

        System.out.printf("\n\nThe perimeter of the triangle is %.05f units", testTriangle.getPerimeter());
        System.out.printf("\nThe area of the triangle is %.05f square units",  testTriangle.getArea());

        System.out.println("\n\nthe triangle is Acute?: " + testTriangle.isAcute());
        System.out.println("the triangle is Obtuse?: " + testTriangle.isObtuse());
        System.out.println("the triangle is Isosceles?: " + testTriangle.isIsosceles());

    }


    /**
     Determines if the user input is a floating point value.

     @param input Scanner object denoting a coordinate.
     @return A floating point value.
     */

    public static double validateInput(Scanner input)
    {

        do
        {
            if (input.hasNextDouble())
            {
                return Double.parseDouble(input.nextLine());

            }else
            {
                input.nextLine();
                System.out.println("Please enter a floating point value. ");
            }

        }while(true);

    }

}