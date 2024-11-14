//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Test data
            // Initialize the roster
            Roster roster = new Roster();

            // Sample Course data
            Course course1 = new Course("ITCS214", "Data Structures", 3, 1);
            Course course2 = new Course("MATH101", "Calculus", 4, 2);
            Course course3 = new Course("PHYS101", "Physics", 3, 1);

            // Sample Students
            Student student1 = new Student(101, "Alice", "Smith", 'F', "alice@example.com", 3.5, 5001);
            Student student2 = new Student(102, "Bob", "Brown", 'M', "bob@example.com", 2.8, 5002);
            Student student3 = new Student(103, "Charlie", "Davis", 'M', "charlie@example.com", 3.2, 5003);

            // Test addStudent
            System.out.println(roster.addStudent(student1)); // Expected: true
            System.out.println(roster.addStudent(student2)); // Expected: true
            System.out.println(roster.addStudent(student3)); // Expected: true
            System.out.println(roster.addStudent(student1)); // Expected: false (duplicate student)

            // Test deleteStudent
            System.out.println(roster.deleteStudent(102)); // Expected: true
            System.out.println(roster.deleteStudent(999)); // Expected: false (non-existent ID)

            // Test searchStudent
            System.out.println(roster.searchStudent(101)); // Expected: 0 (index of student1)
            System.out.println(roster.searchStudent(999)); // Expected: -1 (student not found)

            // Test isEmpty
            System.out.println(roster.isEmpty()); // Expected: false

            // Test listSize
            System.out.println(roster.listSize()); // Expected: 2 (since student2 was deleted)

            // Test getStudent
            Student foundStudent = roster.getStudent(0);
            System.out.println(foundStudent != null ? foundStudent.getFirstName() : "null"); // Expected: "Alice"

            // Test addCourse
            System.out.println(roster.addCourse(course1, 101)); // Expected: true (added to Alice)
            System.out.println(roster.addCourse(course2, 101)); // Expected: true (added to Alice)
            System.out.println(roster.addCourse(course1, 101)); // Expected: false (duplicate course for Alice)

            // Test credit limit in addCourse
            System.out.println(roster.addCourse(course3, 101)); // Expected: true (Alice's GPA allows up to 21 credits)
            System.out.println(roster.addCourse(new Course("HIST101", "History", 6, 1), 101)); // Expected: true (doesn't exceed 21 credits)

            // Test deleteCourse
            System.out.println(roster.deleteCourse(course1, 101)); // Expected: true (removes Data Structures for Alice)
            System.out.println(roster.deleteCourse(course1, 101)); // Expected: false (course not found for Alice)
            System.out.println(roster.deleteCourse(course3, 101)); // Expected: false (drops credits below 12)

            // Test printStudentDetails
            roster.printStudentDetails(101); // Expected: Print details of Alice with her courses
            roster.printStudentDetails(999); // Expected: Print "[!] No Student Information is found for the given id (999)"

            // Test printAdvisor
            roster.printAdvisor(101); // Expected: Print "Student Advisor Number: 5001"
            roster.printAdvisor(999); // Expected: Print "[!] Student with ID=999 is not found. No Student Advisor is found."
//        Roster r = new Roster();
//
//        Student s1 = new Student(202308948, "Taha", "Aljamri", 'M', "t.aljamri55@gmail.com", 4.0, 1);
//        Student s2 = new Student(1, "T2", "A2", 'M', "t.aljamri525@gmail.com", 3.92, 10);
//        Student s3 = new Student(3, "Ali", "Mohammed", 'M', "alooy2005@gmail.com", 3.33, 12);
//        Student s4 = new Student(2, "Fatima", "Mohammed", 'F', "fMohd2005@gmail.com", 2.0, 11);
//
//        r.addStudent(s1);
//        r.addStudent(s2);
//        r.addStudent(s3);
//        r.addStudent(s4);
//        Course c1 = new Course("ITCS214", "Data Structures", 3, 9);
//        Course c2 = new Course("ITCS255", "Discrete Structures II", 3, 1);
//        Course c3 = new Course("STAT273", "Probability and Statistics", 4, 7);
//        Course c4 = new Course("ITSE201", "Intro. to Software Engineering", 4, 1);
//        Course c5 = new Course("ENGL219", "Technical Report Writing", 5, 3);
//        Course c6 = new Course("PHYCS102", "General Physics II", 4, 2);

//        r.addCourse(c1, 202308948);
//        r.addCourse(c2, 202308948);
//        r.addCourse(c3, 202308948);
//        r.addCourse(c4, 202308948);
//        r.addCourse(c5, 202308948);
//        r.printStudentDetails(202308948);

//        r.addCourse(c1, 1); r.addCourse(c1, 2);
//        r.addCourse(c2, 1); r.addCourse(c1, 3);
//        r.addCourse(c3, 1);
//        r.addCourse(c4, 1);
//        r.addCourse(c6, 1);
//        r.addCourse(c5, 1);
//        System.out.println("d1: " + r.deleteCourse(c2, 5));
//        System.out.println("d2: " + r.deleteCourse(c2, 1));
//
//        r.printStudentDetails(1);
//        r.printAdvisor(99);
//        r.addCourse(c1, 1); r.addCourse(c1, 2);
//        r.addCourse(c2, 1); r.addCourse(c1, 3);
//        r.addCourse(c3, 1);
//        r.addCourse(c4, 1);
//        r.addCourse(c6, 1);
//        r.addCourse(c5, 1);
//
//        r.deleteStudent(-1);
//        r.printAll( );
//        System.out.println("\n\n");
//        r.deleteStudent(1);
//        r.deleteStudent(202308948);
//
//        r.printAll();
    }
}