package src;

import java.util.ArrayList;

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
public class Student {

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
