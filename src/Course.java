package src;

import java.util.Objects;

/**
 * Represents a course in the university system.
 * Each course has a course number, name, number of credits, and a section.
 */
public class Course {
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
