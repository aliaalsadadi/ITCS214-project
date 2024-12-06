package src;

import java.util.*;

// Student Names: Taha Fadhel A.Jabbar, Ali Alaa Alsadadi, Zuhair Mohammed Alshabbaq
// Student IDs:         202308948     ,     2023005500   ,      202308683
// Section : 09


/**
 * Represents a course in the university system.
 * Each course has a course number, name, number of credits, and a section.
 */
class Course {
    private String courseNum;
    private String courseName;
    private int credits;
    private int section;

    /**
     * Default constructor that initializes a course with default values.
     *   <ul>
     *     <li>Attributes of type String are initialized as "NULL"</li>
     *     <li>Attributes of type Long/Integer/Double are initialized as 0</li>
     *   </ul>
     */
    public Course() {
        courseName = "";
        courseNum = "";
        credits = 0;
        section = 0;
    }

    /**
     * Constructor that initializes a course with the specified values.
     *
     * @param courseNum The course number (e.g., "ITCS214").
     * @param courseName The name of the course (e.g., "Data Structures").
     * @param credits The number of credits the course is worth.
     * @param section The section number of the course.
     */
    public Course(String courseNum, String courseName, int credits, int section) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.credits = credits;
        this.section = section;
    }

    /**
     * Compares this course with another course to see if they are equal.
     * Two courses are considered equal if their course number, name, credits, and section are all the same.
     *
     * @param course The course to compare this course with.
     * @return {@code true} if the courses are equal, {@code false} otherwise.
     */
    public boolean equals(Course course) {
        return credits == course.credits && section == course.section && courseNum.equals(course.courseNum) && courseName.equals(course.courseName);
    }

    /**
     * Gets the course number.
     *
     * @return The course number
     */
    public String getCourseNum() {
        return courseNum;
    }

    /**
     * Sets the course number.
     *
     * @param courseNum The course number.
     */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the section number of the course.
     *
     * @return The section number of the course.
     */
    public int getSection() {
        return section;
    }

    /**
     * Sets the section number of the course.
     *
     * @param section The section number of the course.
     */
    public void setSection(int section) {
        this.section = section;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName The name of the course.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the number of credits the course is worth.
     *
     * @return The number of credits for the course.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits for the course.
     *
     * @param credits The number of credits for the course.
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Returns a string representation of the course with details such as course number,
     * course name, credits, and section.
     *
     * @return A string representing the course.
     */
    @Override
    public String toString() {
        return ("Course Number: " + courseNum + "\n" +
                "Course Name: " + courseName + "\n" +
                "Course Credits: " + credits + "\n" +
                "Course Section: " + section);
    }
}


/**
 * Represents a student in the university registration system.
 * A student is identified by a unique student ID and has various personal and academic details.
 * The student can be associated with multiple courses through the courses registered attribute.
 *
 * <p>Each student has the following attributes:</p>
 * <ul>
 *   <li>Student ID number</li>
 *   <li>First name</li>
 *   <li>Last name</li>
 *   <li>Gender</li>
 *   <li>Email address</li>
 *   <li>Grade Point Average (GPA)</li>
 *   <li>Advisor number</li>
 *   <li>A list of courses the student is registered for</li>
 * </ul>
 *
 * <p>This class provides methods for accessing and modifying student details,
 * as well as managing the courses a student is registered for.</p>
 */
class Student {

    private long idNum;
    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private double GPA;
    private long advisorNum;
    private ArrayList<Course> coursesRegistered;


    /**
     * Constructs a new Student object with the default values.
     * <ul>
     *     <li>Attributes of type String are initialized as "NULL"</li>
     *     <li>The attribute Gender is initialized as 'U' standing for Unknown</li>
     *     <li>Attributes of type Long/Integer/Double are initialized as 0</li>
     *     <li>The attribute coursesRegistered is initialized as an empty ArrayList</li>
     * </ul>
     */
    public Student() {
        this.idNum = 0;
        this.firstName = "NULL";
        this.lastName = "NULL";
        this.gender = 'U';
        this.email = "NULL";
        this.coursesRegistered = new ArrayList<>();
        this.GPA = 0.0;
        this.advisorNum = 0;
    }

    /**
     * Constructs a new Student object with the specified attributes.
     *
     * @param idNum       the unique ID number of the student
     * @param firstName   the first name of the student
     * @param lastName    the last name of the student
     * @param gender      the gender of the student ('M' for male, 'F' for female)
     * @param email       the email address of the student
     * @param GPA         the Grade Point Average of the student
     * @param advisorNum  the unique ID number of the student's advisor
     */
    public Student(long idNum, String firstName, String lastName, char gender, String email, double GPA, long advisorNum) {
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.GPA = GPA;
        this.coursesRegistered = new ArrayList<>(); // Initialize with empty list
        this.advisorNum = advisorNum;
    }


    /**
     * Gets the student's unique ID number.
     *
     * @return the student's ID number
     */
    public long getIdNum() {
        return idNum;
    }

    /**
     * Sets the student's unique ID number.
     *
     * @param idNum the student's ID number to set
     */
    public void setIdNum(long idNum) {
        this.idNum = idNum;
    }

    /**
     * Gets the student's first name.
     *
     * @return the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName the student's first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return the student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's gender.
     *
     * @return the student's gender as a character ('M' for male, 'F' for female, etc.)
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the student's gender.
     *
     * @param gender the student's gender to set ('M' for male, 'F' for female, etc.)
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Gets the student's email address.
     *
     * @return the student's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email the student's email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the list of courses registered by the student.
     *
     * @return a list of courses the student is registered for
     */
    public ArrayList<Course> getCoursesRegistered() {
        return this.coursesRegistered;
    }

    /**
     * Sets the list of courses registered by the student.
     * A copy of the provided list is stored to avoid external modification.
     *
     * @param coursesRegistered the list of courses to set
     */
    public void setCoursesRegistered(ArrayList<Course> coursesRegistered) {
        this.coursesRegistered = new ArrayList<>(coursesRegistered);
    }

    /**
     * Gets the student's Grade Point Average (GPA).
     *
     * @return the student's GPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets the student's Grade Point Average (GPA).
     *
     * @param GPA the student's GPA to set
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    /**
     * Gets the advisor's unique number assigned to the student.
     *
     * @return the advisor's number
     */
    public long getAdvisorNum() {
        return advisorNum;
    }


    /**
     * Sets the student's advisor Number (advisorNum)
     *
     * @param advisorNum
     */
    public void setAdvisorNum(long advisorNum) {
        this.advisorNum = advisorNum;
    }

    /**
     * compares the id's of this Student and s Student
     *
     * @param s object of type student
     * @return true if the id of s is equal to the id of this student
     */
    public boolean equals(Student s) {
        return s.idNum == this.idNum;
    }

    /**
     * Prints the list of courses that the student is registered for with their details.
     */
    public void printCoursesRegistered() {
        if (coursesRegistered.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Courses:");
            for (int i = 1; i <= coursesRegistered.size(); i++) {
                if (i == 1)
                    System.out.println("========");
                System.out.print("[" + i + "] ");
                System.out.println(coursesRegistered.get(i-1).toString());
                System.out.println("========");
            }
        }
    }

}


/**
 * Represents a roster of students in a university registration system.
 * It provides methods to add, delete, and search for students, as well as course management methods.
 */
class Roster {
    private LinkedList<Student> studentsList;
    private int size;

    /**
     * Constructs a new empty roster.
     * <p>
     *     <li> Initializes thr attribute studentsList to an empty LinkedList </li>
     *     <li> Initializes thr attribute size to 0 </li>
     * </p>
     */
    public Roster() {
        studentsList = new LinkedList<>();
        size = 0;
    }


    /**
     * Adds a student to the roster while maintaining the ascending order of students based on their ID.
     * The student will only be added if they do not already exist in the roster.
     *
     * @param st The student to be added to the roster.
     * @return true if the student was added successfully, false if the student already exists.
     */
    public boolean addStudent(Student st) {
        if (st == null) return false;

        // Check if the student already exists in the list
        ListIterator<Student> iter = studentsList.listIterator();
        while (iter.hasNext()) {
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st.getIdNum()) {
                return false; // Student already exists
            }
        }

        // If roster is empty, add the student to the first position
        if (size == 0) {
            studentsList.addFirst(st);
            size++;
            return true;
        }

        // Reset the list iterator to index 0 for inserting in ascending order
        iter = studentsList.listIterator();

        // Traverse the list and find the correct insertion index based on ascending student IDs
        while (iter.hasNext()) {
            Student foundSt = iter.next();
            if (foundSt.getIdNum() > st.getIdNum()) {
                iter.previous(); // Move back to correct insertion point
                iter.add(st);    // Add the student in the correct order
                size++;
                return true;
            }
        }

        // If no position was found, then the student ID is greater that all other IDs and should be inserted at the end of the list
        iter.add(st);
        size++;
        return true;
    }

    /**
     * Deletes a student from the roster by their ID.
     *
     * @param st_id The ID of the student to be deleted.
     * @return true if the student was found and deleted, false otherwise.
     */
    public boolean deleteStudent(long st_id) {
        if (size == 0) return false;
        ListIterator<Student> iter = studentsList.listIterator();
        while (iter.hasNext()) { // Iterate through the studentsList
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st_id) {
                iter.remove(); // Student having the id of st_id is found, delete it and decrement the size by 1.
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for a student in the roster by their ID.
     *
     * @param st_id The ID of the student to search for.
     * @return The index of the student in the list, or -1 if the student is not found.
     */
    public int searchStudent(long st_id) {
        ListIterator<Student> iter = studentsList.listIterator();
        while (iter.hasNext()) {
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st_id) {
                return iter.previousIndex(); // Student having the id of st_id is found, return its index. previousIndex() is called to get the current index not the next one
            }
        }
        return -1;
    }

    /**
     * Checks if the roster is empty.
     *
     * @return true if the roster has no students, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the number of students in the roster.
     *
     * @return The number of students in the roster.
     */
    public int listSize() {
        return size;
    }

    /**
     * Retrieves a student from the roster by their index.
     *
     * @param index The index of the student to retrieve.
     * @return The student at the specified index, or null if the index is out of bounds.
     */
    public Student getStudent(int index) {
        if (index < 0 || index >= size) return null;
        ListIterator<Student> iter = studentsList.listIterator();
        for (int i = 0; i < index && iter.hasNext(); i++) {
            iter.next();
        }
        return iter.next();
    }

    /**
     * Adds a course to a student's list of registered courses.
     * The course will be added only if the following conditions are satisfied:
     * <ul>
     *     <li> Course does not exist in the coursesRegistered list for the Student </li>
     *     <li> After adding the course, the number of credits do not exceed 18 </li>
     *     <li> In case the student GPA is more than 3.00, up to 21 credits are accepted</li>
     *     <li></li>
     * </ul>
     *
     * @param course The course to add.
     * @param st_id The ID of the student to add the course to.
     * @return true if the course was added successfully, false if the student cannot register for more credits or the course already exists.
     */
    public boolean addCourse(Course course, long st_id) {
        if (course == null) return false;
        int st_index = searchStudent(st_id); // get the index of the student having an id of st_id
        if (st_index == -1) return false; // student not found in the studentList
        Student st = getStudent(st_index); // Create an object of Student found
        ArrayList<Course> rCourses = st.getCoursesRegistered();
        int noOfCredits_afterAdd = course.getCredits(); // initialize to the credits of the course to be added, to verify the total credits after addition
        for (Course r : rCourses) {
            noOfCredits_afterAdd += r.getCredits();
            if (r.getCourseNum().equals(course.getCourseNum()))
                return false; // student already having the course in their coursesRegistered
        }
        if (st.getGPA() > 3.00) {
            if (noOfCredits_afterAdd > 21) {
                System.out.println("[X] Total Credits exceeds 21 after addition");
                return false;
            }
        } else {
            if (noOfCredits_afterAdd > 18) {
                System.out.println("[X] Total Credits exceeds 18 after addition");
                return false;
            }
        }
        rCourses.add(course); // all conditions are satisfied, add the course to the student registerCourses list
        st.setCoursesRegistered(rCourses);
        return true;
    }

    /**
     * Deletes a course from a student's list of registered courses.
     * The course can only be removed if
     * <ul>
     *     <li> the course exist in the student's  list of registeredCourse</li>
     *     <li> the student will have at least 12 credits after removal </li>
     * </ul>
     *
     * @param course The course to delete.
     * @param st_id The ID of the student to delete the course from.
     * @return true if the course was deleted successfully, false if the course is not found or the student would have less than 12 credits after removal.
     */
    public boolean deleteCourse(Course course, long st_id) {
        if (course == null) return false;
        int st_index = searchStudent(st_id); // get the index of the student having an id of st_id
        if (st_index == -1) {
            System.out.println("[X] Student cannot be found.");
            return false; // student not found in the studentList
        }
        Student st = getStudent(st_index); // Create an object of Student found
        ArrayList<Course> rCourses = st.getCoursesRegistered();
        int indexOfCourse = 0;
        boolean found = false;
        int noOfCredits_afterRemoval = 0; // To calculate the total credits after removing the course
        for (int i = 0; i < rCourses.size(); i++) {
            Course r = rCourses.get(i);
            noOfCredits_afterRemoval += r.getCredits();
            if (r.equals(course)) {
                indexOfCourse = i;
                found = true;
            }
        }
        if (!found) {
            System.out.println("[X] The course to be removed is not found.");
            return false;
        }
        noOfCredits_afterRemoval -= course.getCredits();
        if (noOfCredits_afterRemoval < 12) {
            System.out.println("[X] The course can't be removed. The total no. of credits must be greater than 12 after removal.");
            return false;
        } else {
            rCourses.remove(indexOfCourse);
            st.setCoursesRegistered(rCourses);
            return true;
        }
    }

    /**
     * Prints the details of a student based on their student ID.
     *
     * @param st_id The ID of the student whose details are to be printed.
     */
    public void printStudentDetails(long st_id) {
        int st_index = searchStudent(st_id); // Find the index of the student having an id of st_id
        if (st_index == -1) {
            System.out.println("[X] No Student Information is found for the given id (" + (st_id) + ")");
            return;
        }
        Student st = getStudent(st_index);
        System.out.println("------------------------\nStudent Details\n------------------------");
        System.out.println("ID: " + st.getIdNum());
        System.out.println("First Name: " + st.getFirstName());
        System.out.println("Last Name: " + st.getLastName());
        System.out.println("Email: " + st.getEmail());
        System.out.println("GPA: " + st.getGPA());
        System.out.println("Gender: " + st.getGender());
        System.out.println("Advisor Number: " + st.getAdvisorNum());
        st.printCoursesRegistered(); // print the student's registeredCourses using the Student Class printCoursesRegistered method
    }

    /**
     * Prints the advisor's number for a student.
     *
     * @param st_id The ID of the student whose advisor number is to be printed.
     */
    public void printAdvisor(long st_id) {
        int st_index = searchStudent(st_id); // Find the index of the student having an id of st_id
        if (st_index == -1) {
            System.out.println("[!] Student with ID=" + (st_id) + " is not found. No Student Advisor is found.");
            return;
        }
        Student st = getStudent(st_index);
        System.out.println("Student Advisor Number: " + st.getAdvisorNum());
    }
}


/**
 * The Registration class provides a menu-driven interface for managing
 * a university registration system. It allows users to add and delete students,
 * manage course registrations, and retrieve student information.
 */
class Registration {
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
        System.out.println("\nUniversity Registration System");
        do {
            // Listing all the options
            System.out.println("\n1. Add a student  |  2. Add course  |  3. Search for student by ID");
            System.out.println("4. Delete a course from student  |  5. Delete a student");
            System.out.println("6. Print all student IDs  |  0. Exit");
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
                    case 3:
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
                    case 4:
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
                    case 5:
                        System.out.print("Enter Student ID: ");
                        long deleteId = scanner.nextLong();
                        scanner.nextLine();
                        if (r.deleteStudent(deleteId)) {
                            System.out.println("[!] Student deleted successfully.");
                        } else {
                            System.out.println("[X] Student not found.");
                        }
                        break;
                    case 6:
                        if (r.listSize() == 0)
                        {
                            System.out.println("[!] Roaster has no students.");
                            continue;
                        }
                        System.out.println("[!] Roaster has " + r.listSize() + " students.");
                        System.out.println("[!] Student IDs: ");
                        for (int i = 0; i < r.listSize(); i++) {
                            System.out.println(r.getStudent(i).getIdNum());
                        }
                        System.out.println();
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

