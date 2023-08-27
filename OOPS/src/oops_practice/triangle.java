package oops_practice;

import java.util.Scanner;

public class triangle {
    int side1;
    int side2;
    int side3;

    public int area(int side1, int side2){
        return side1*side2;
    }
    public int perimeter(int side1, int side2, int side3){
        return side1 + side2 + side3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();
        triangle t1 = new triangle();
        int ans_area = t1.area(side1, side2);
        int ans_perimeter = t1.perimeter(side1, side2, side3);
        System.out.println(ans_area);
        System.out.println(ans_perimeter);
    }
}

