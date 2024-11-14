import java.util.Objects;

public class Course {
    private String courseNum;
    private String courseName;
    private int credits;
    private int section;

    public Course(

    ) {
        courseName = "";
        courseNum = "";
        credits = 0;
        section = 0;
    }

    public Course(String courseNum, String courseName, int credits, int section) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.credits = credits;
        this.section = section;
    }
    public boolean equals(Course course) {
        return credits == course.credits && section == course.section && courseNum.equals(course.courseNum) && courseName.equals(course.courseName);
    }
    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
