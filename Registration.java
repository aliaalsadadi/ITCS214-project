import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Roster r = new Roster();
        int choice;

        do {
            System.out.println("\nUniversity Registration System");
            System.out.println("1. Add a student");
            System.out.println("2. Delete a student");
            System.out.println("3. Search student");
            System.out.println("4. Cheak if Roster is Empty");
            System.out.println("5. Get Roster size");
            System.out.println("6. Get student by index");
            System.out.println("7. Add course to student");
            System.out.println("8. Delete course from student ");
            System.out.println("9. Print student details ");
            System.out.println("10. Print Advisor for student ");
            System.out.println("11. Print all student IDs");
            System.out.println("12. Get Student course Info");
            System.out.println("0. Exit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add a student");
                    System.out.println("Enter Student ID:");
                    long id = scanner.nextLong();
                    System.out.println("Enter First Name:");
                    String firstName = scanner.next();
                    System.out.println("Enter Last Name:");
                    String lastName = scanner.next();
                    System.out.println("Enter Gender (M/F):");
                    char gender = scanner.next().charAt(0);
                    System.out.println("Enter Email:");
                    String email = scanner.next();
                    System.out.println("Enter Advisor Number:");
                    long advisorNum = scanner.nextLong();
                    Student st = new Student(id, firstName, lastName, gender, email, advisorNum);
                    if (r.addStudent(st)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student already exists.");
                    }
                    break;
                case 2:
                    System.out.println("Delete a student ");
                    int deleteId = scanner.nextInt();
                    if (r.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;
                case 3:
                    System.out.println("Search a student .");
                    int searchId = scanner.nextInt();
                    int position = r.searchStudent(searchId);
                    if (position != -1) {
                        System.out.println("Student found at position: " + position);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Cheak if Roster is Empty.");
                    if (r.isEmpty()) ;
                    break;
                case 5:
                    System.out.println("Get Roster size.");
                    System.out.println("Number of students in the roster: " + r.listSize());
                    break;
                case 6:
                    System.out.println("Get student by index.");
                    int index = scanner.nextInt();
                    r.getStudent(index);

                    break;
                case 7:
                    System.out.println("Add course to student.");
                    System.out.println("Enter Student ID:");
                    long studentId = scanner.nextLong();
                    System.out.println("Enter Course Number:");
                    String courseNum = scanner.next();
                    System.out.println("Enter Course Name:");
                    String courseName = scanner.next();
                    System.out.println("Enter Credits:");
                    int credits = scanner.nextInt();
                    System.out.println("Enter Section:");
                    int section = scanner.nextInt();

                    Course c = new Course(courseNum, courseName, credits, section);
                    if (r.addCourse(c, (int) studentId)) {
                        System.out.println("Course added successfully.");
                    } else {
                        System.out.println("Failed to add course. Please check constraints.");
                    }
                    break;
                case 8:
                    System.out.println("Delete course from student.");
                    System.out.println("Enter Student ID:");
                    long stuId = scanner.nextLong();
                    System.out.println("Enter Course Number:");
                    String delCourseNum = scanner.next();
                    break;
                case 9:
                    System.out.println("Print student details");
                    System.out.println("Enter Student ID:");
                    int stuDetailId = scanner.nextInt();
                    r.printStudentDetails(stuDetailId);
                    break;
                case 10:
                    System.out.println("Print Advisor for student ");
                    System.out.println("Enter Student ID:");
                    int advisorId = scanner.nextInt();
                    r.printAdvisor(advisorId);
                    break;
                case 11:
                    System.out.println(" Print all student IDs");
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


            scanner.close();
        }while (true);
    }
}
