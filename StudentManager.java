import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double math;
    double science;

    Student(String name, double math, double science) {
        this.name = name;
        this.math = math;
        this.science = science;
    }

    double average() {
        return (math + science) / 2;
    }
}

public class StudentManager {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add student");
            System.out.println("2. Show students");
            System.out.println("3. Exit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Math Score: ");
                double math = input.nextDouble();

                System.out.print("Science Score: ");
                double science = input.nextDouble();

                students.add(new Student(name, math, science));
            }

            else if (choice == 2) {
                for (Student s : students) {
                    System.out.println("Name: " + s.name +
                            " Avg: " + s.average());
                }
            }

            else if (choice == 3) {
                break;
            }
        }
    }
}
