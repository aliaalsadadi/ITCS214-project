package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Represents a roster of students in a university registration system.
 * It provides methods to add, delete, and search for students, as well as course management methods.
 */
public class Roster {
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
