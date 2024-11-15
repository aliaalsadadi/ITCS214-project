import java.util.ArrayList;

public class Student {
    /*
    * idNum (long), firstName (String), lastName (String), gender (char), email (String),
coursesRegistered (ArrayList of type Course), GPA (double), advisorNum
(long)
* */
    private long idNum;
    private String firstName, lastName;
    private char gender;
    private String email;
    private ArrayList<Course> coursesRegistered;
    private double GPA;
    private long advisorNum;

    public Student() {
        this.idNum = 0;                         // Default ID, could be a placeholder value
        this.firstName = "";             // Default first name
        this.lastName = "";              // Default last name
        this.gender = ' ';                      // 'U' for unknown gender
        this.email = "";     // Placeholder email
        this.coursesRegistered = new ArrayList<>(); // Initialize with empty list
        this.GPA = 0.0;                         // Default GPA
        this.advisorNum = 0;                    // Default advisor number
    }

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

    public long getIdNum() {
        return idNum;
    }

    public void setIdNum(long idNum) {
        this.idNum = idNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Course> getCoursesRegistered() {
        return this.coursesRegistered;
    }

    public void setCoursesRegistered(ArrayList<Course> coursesRegistered) {
        // Create a new ArrayList to store a copy of the courses
        this.coursesRegistered = new ArrayList<>(coursesRegistered);
    }


    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public long getAdvisorNum() {
        return advisorNum;
    }

    public void setAdvisorNum(long advisorNum) {
        this.advisorNum = advisorNum;
    }
    public boolean equals(Student s) {
        return s.idNum == this.idNum;
    }
    public void printCoursesRegistered() {
        System.out.println("Courses registered for student with id:"+ idNum);
        for (int i = 0; i < coursesRegistered.size(); i++) {
            System.out.println(coursesRegistered.get(i).toString());
        }
    }
}
