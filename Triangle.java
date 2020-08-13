
import java.awt.Point; // To store coordinates as a point object

public class Triangle

{

    private Point pointA = new Point();
    private Point pointB = new Point();
    private Point pointC = new Point();

    private  final double EPSILON = 0.9; // Margin of error
    private final int RIGHT_ANGLE = 90; // The degree of a right angle


    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {

     this.pointA.setLocation(x1, y1);
     this.pointB.setLocation(x2, y2);
     this.pointC.setLocation(x3, y3);

    }


    public Triangle(Point pointA, Point pointB, Point pointC)
    {

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;

    }



    /**
        Determines the distance between the points opposite of point A.
        Note: Uses the distance method in the Point class

        @return Distance between point B and C
     */
    public double getPointALength()
    {
        return this.pointB.distance(this.pointC);
    }



     /**
         Determines the distance between the points opposite of point B.
         Note: Uses the distance method in the Point class

         @return Distance between point A and C
     */

    public double getPointBLength()
    {
        return this.pointA.distance(this.pointC);
    }



    /**
        Determines the distance between the points opposite of C.
        Note: Uses the distance method in the Point class

        @return Distance between point A and B
     */

    public double getPointCLength()
    {
        return this.pointA.distance(this.pointB);
    }



    /**
         Determines the angle of point A.

         Formula: COS(A) = b^2 + c^2 - a^2 / 2bc

         Note: This formula is from https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html

               a, b, c represents the length of points A, B, C.

         @return The angle of point A in degrees.
     */

    public double getPointAAngle()
    {
        double sideA = getPointALength();
        double sideB = getPointBLength();
        double sideC = getPointCLength();

        double numerator = (Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2));
        double denominator = 2 * sideB * sideC;

        return Math.toDegrees(Math.acos(numerator / denominator));
    }




    /**
         Determines the angle of point B.

         Formula: COS(B) = c^2 + a^2 - b^2 / 2ca

         Note: This formula is from https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html

               a, b, c represents the length of points A, B, C.


          @return The angle of point B in degrees.
     */


    public double getPointBAngle()
    {
        double sideA = getPointALength();
        double sideB = getPointBLength();
        double sideC = getPointCLength();

        double numerator =  (Math.pow(sideC, 2) + Math.pow(sideA, 2) - Math.pow(sideB, 2));
        double denominator = 2 * sideC * sideA;

        return Math.toDegrees(Math.acos(numerator / denominator));

    }


    /**
         Determines the angle of point C.

         Formula: COS(C) = a^2 + b^2 - c^2 / 2ab

         Note: This formula is from https://www.mathsisfun.com/algebra/trig-solving-sss-triangles.html

                a, b, c represents the length of points A, B, C.

         @return The angle of point C in degrees.
     */


    public double getPointCAngle()
    {
        double sideA = getPointALength();
        double sideB = getPointBLength();
        double sideC = getPointCLength();

        double numerator = (Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2));
        double denominator =  (2 * sideA * sideB);

        return Math.toDegrees(Math.acos(numerator / denominator));
    }



    /**

         Determines the perimeter of the triangle.

         Formula: a + b + c

         Note: This formula is from https://www.mathsisfun.com/geometry/perimeter.html

                a, b, c represents length of points A, B, C.

         @return The perimeter of the triangle.
     */


    public double getPerimeter()
    {
        return getPointALength() + getPointBLength() + getPointCLength();
    }



    /**

         Determines the area of the triangle.

         Formula: Area = sqr( p (p - a) (p - b) (p - c) )

                  p = a + b + c / 2


         Note: This formula is from https://www.mathopenref.com/heronsformula.html

               p represents half of the perimeter.
               a, b, c represents length of points A, B, C.

         @return The area of the triangle.
     */


    public double getArea()
    {
        double sideA = getPointALength();
        double sideB = getPointBLength();
        double sideC = getPointCLength();

        double half_perimeter = getPerimeter() / 2;

        double pMinusA = half_perimeter - sideA;
        double pMinusB = half_perimeter - sideB;
        double pMinusC = half_perimeter - sideC;

        return Math.sqrt(half_perimeter * pMinusA * pMinusB * pMinusC);
    }



    /**
        Determines if the triangle is acute.

        Note: A triangle is acute if all angles are less than 90°.

              Definition Link: https://www.mathsisfun.com/definitions/acute-triangle.html

        @return A boolean value denoting true if the triangle is acute, otherwise false.

     */

    public boolean isAcute()
    {
        double angleA = getPointAAngle();
        double angleB = getPointBAngle();
        double angleC = getPointCAngle();

        boolean angleAAcute = angleA < RIGHT_ANGLE;
        boolean angleBAcute = angleB < RIGHT_ANGLE;
        boolean angleCAcute = angleC < RIGHT_ANGLE;

        return angleAAcute && angleBAcute && angleCAcute;

    }



    /**
        Determines if the triangle is obtuse.

        Note: A triangle is obtuse if one of its angle is greater than 90°.

              Definition Link: https://www.mathsisfun.com/definitions/obtuse-triangle.html

        @return A boolean value denoting true if the triangle is obtuse, otherwise false.

     */

    public boolean isObtuse()
    {
        double angleA = getPointAAngle();
        double angleB = getPointBAngle();
        double angleC = getPointCAngle();

        boolean angleAObtuse = angleA > RIGHT_ANGLE + EPSILON;
        boolean angleBObtuse = angleB > RIGHT_ANGLE + EPSILON;
        boolean angleCObtuse = angleC > RIGHT_ANGLE + EPSILON;

        return angleAObtuse || angleBObtuse || angleCObtuse;
    }



    /**
        Determines if the triangle is isosceles.

        Note: A triangle is isosceles if it has two equal legs.
              You can determine if a triangle is isosceles by using the isosceles triangle theorem.

              Definition Link: https://tutors.com/math-tutors/geometry-help/isosceles-triangle-theorem

        @return A boolean value denoting true if the triangle is isosceles, otherwise false.

     */


    public boolean isIsosceles()
    {

        double angleA = getPointAAngle();
        double angleB = getPointBAngle();
        double angleC = getPointCAngle();

        boolean angleAEqualB = (Math.abs(angleA - angleB) < EPSILON);
        boolean angleAEqualC = (Math.abs(angleA - angleC) < EPSILON);
        boolean angleCEqualB = (Math.abs(angleC - angleB) < EPSILON);

        return angleAEqualB || angleAEqualC || angleCEqualB;
    }

}