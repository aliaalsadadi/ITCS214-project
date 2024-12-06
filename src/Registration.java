package src;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Registration class provides a menu-driven interface for managing
 * a university registration system. It allows users to add and delete students,
 * manage course registrations, and retrieve student information.
 */
public class Registration {
    /**
     * The main method that runs the university registration system.
     * <p>
     *     Note:  To avoid any bugs, scanner.nextLine() is used to clear empty lines in the input buffer.
     * </p>
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Roster r = new Roster();
        int choice;

        do {
            // Listing all the options
            System.out.println("\nUniversity Registration System");
            System.out.println("1. Add a student  |  2. Delete a student  |  3. Get Roster size");
            System.out.println("4. Search for student by ID  |  5. Search for student by index  |  6. Add course to student");
            System.out.println("7. Delete course from student  |  8. Print all student IDs  |  0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            // A try is used to handle any exceptions (e.g., InputMismatchException) instead of crashing the application
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        long id = scanner.nextLong();
                        if (r.searchStudent(id) != -1) {
                            System.out.println("[X] Student with ID of " + id + " already exist");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Gender (M/F): ");
                        char gender =  Character.toUpperCase(scanner.next().charAt(0)); // Capitalize to ensure standardization
                        if (gender != 'M' && gender != 'F'){ // Validate the gender input. It has to be either M or F
                            System.out.println("[X] Please enter a valid gender, either M for male or F for female: ");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Advisor Number: ");
                        long advisorNum = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter Student GPA: ");
                        double GPA = scanner.nextDouble();
                        scanner.nextLine();
                        Student st = new Student(id, firstName, lastName, gender, email, GPA, advisorNum);
                        if (r.addStudent(st)) {
                            System.out.println("[!] Student added successfully.");
                        } else {
                            System.out.println("[!] Student already exists.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        long deleteId = scanner.nextLong();
                        scanner.nextLine();
                        if (r.deleteStudent(deleteId)) {
                            System.out.println("[!] Student deleted successfully.");
                        } else {
                            System.out.println("[X] Student not found.");
                        }
                        break;
                    case 3:
                        System.out.println("[!] Number of students in the roster: " + r.listSize());
                        break;
                    case 4:
                        System.out.print("Enter Student ID: ");
                        long searchId = scanner.nextLong();
                        scanner.nextLine();
                        int position = r.searchStudent(searchId);
                        if (position != -1) {
                            System.out.println("[!] Student found at position: " + position);
                            r.printStudentDetails(searchId);
                        } else {
                            System.out.println("[X] Student not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter an index: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        Student s = r.getStudent(index);
                        if (s != null) {
                            r.printStudentDetails(s.getIdNum());
                        } else {
                            System.out.println("[X] No student found at the specified index.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter Student ID: ");
                        long studentId = scanner.nextLong();
                        if (r.searchStudent(studentId) == -1) {
                            System.out.println("[X] No student with ID of " + studentId + " is found");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                        System.out.print("Enter Course Number: ");
                        String courseNum = scanner.nextLine();
                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter Credits: ");
                        int credits = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Section: ");
                        int section = scanner.nextInt();
                        scanner.nextLine();
                        Course c = new Course(courseNum, courseName, credits, section);
                        if (r.addCourse(c, studentId)) {
                            System.out.println("[!] Course added successfully.");
                        } else {
                            System.out.println("[X] Failed to add course. Please check constraints.");
                        }
                        break;
                    case 7:
                        System.out.print("Enter Student ID: ");
                        long stuId = scanner.nextLong();
                        if (r.searchStudent(stuId) == -1) {
                            System.out.println("[X] No student with ID of " + stuId + " is found");
                            scanner.nextLine();
                            continue;
                        }
                        scanner.nextLine();
                        System.out.print("Enter Course Number: ");
                        String delCourseNum = scanner.next();
                        scanner.nextLine();
                        System.out.print("Enter Course Name: ");
                        String delCourseName = scanner.nextLine();
                        System.out.print("Enter Credits: ");
                        int delCourseCredit = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Section: ");
                        int delCourseSection = scanner.nextInt();
                        Course delCourse = new Course(delCourseNum, delCourseName, delCourseCredit, delCourseSection);
                        if (r.deleteCourse(delCourse, stuId)) {
                            System.out.println("[!] Course deleted successfully.");
                        } else {
                            System.out.println("[X] Failed to delete course.");
                        }
                        break;
                    case 8:
                        for (int i = 0; i < r.listSize(); i++) {
                            System.out.println("[!] Student ID: " + r.getStudent(i).getIdNum());
                        }
                        break;
                    case 0:
                        System.out.println("[!] Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("[X] Invalid choice. Please try again.");
                }
            } catch (InputMismatchException ex1) {
                System.out.println("[X] Please enter correct type of data");
                scanner.nextLine();
            } catch (Exception ex2) {
                System.out.println("[X] An error occurred: " + ex2.getMessage());
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }
}
