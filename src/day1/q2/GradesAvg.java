package day1.q2;

import java.util.Scanner;

public class GradesAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents;
        int marks;
        System.out.println("number of students ");
        numStudents=scanner.nextInt();
        double average=0.0;
        double total=0.0;
        int grades[]=new int[numStudents];
        int counter=0;
        while(counter<numStudents){
            System.out.println("enter grades for student " + (counter+1));
            marks=scanner.nextInt();
            if(marks>100 || marks<0){
                System.out.println("invalid");
            }
            grades[counter++]=marks;
        }
        for(int grade:grades){
            total+=grade;
        }
        System.out.println("total marks :" + total);
        average=total/grades.length;
        System.out.println("average" + average);
    }
}
