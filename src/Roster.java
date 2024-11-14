import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Roster {
    LinkedList<Student> studentsList;
    int size;

    public Roster(){
        studentsList = new LinkedList<>();
        size = 0;
    }

    public boolean addStudent(Student st){
        if (st == null) return false;
        ListIterator<Student> iter = studentsList.listIterator();
        while (iter.hasNext()){
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st.getIdNum()){ /* && foundSt.getFirstNAme().equals(st.getFirstNAme())
                && foundSt.getLastName().equals(st.getLastName()) && foundSt.getEmail().equals(st.getEmail()) */
                return false;
            }
        }
        if (size == 0) {studentsList.addFirst(st); size++;return true;}
        iter = studentsList.listIterator(); // Reset the listIterator to index 0
        while (iter.hasNext()){
            Student foundSt = iter.next();
            if (foundSt.getIdNum() > st.getIdNum()){
                iter.previous();
                iter.add(st);
                size++;
                return true;
            }
        }
        iter.add(st); // This ensures the students are added without affecting the ascending order of the LinkedList
        size++;
        return true;

    }

    public boolean deleteStudent(int st_id){
        if (size == 0) return false;
        ListIterator<Student> iter = studentsList.listIterator();
        while (iter.hasNext()){
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st_id){
               iter.remove(); size--;return true;
            }
        }
        return false;
    }

    public int searchStudent(int st_id){
        ListIterator<Student> iter = studentsList.listIterator();
        int c = 0;
        while (iter.hasNext()){
            Student foundSt = iter.next();
            if (foundSt.getIdNum() == st_id){
               return c;
            } else {
                c++;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int listSize(){
        return size;
    }
    public Student getStudent(int index){
        if (index < 0 || index >= size) return null;
        ListIterator<Student> iter = studentsList.listIterator();
        for(int i = 0; i<index && iter.hasNext(); i++){
            iter.next();
        }
        return iter.next();
    }

    public boolean addCourse(Course course, int st_id){
        int st_index = searchStudent(st_id);
        if (st_index == -1) return false;
        Student st = getStudent(st_index);
        ArrayList<Course> rCourses = st.getCoursesRegistered();
        int noOfCredits_afterAdd = 0;
        for( Course r : rCourses){
            noOfCredits_afterAdd += r.getCredits();
            if (r.getCourseNum().equals(course.getCourseNum()))
                return false;
        }
        noOfCredits_afterAdd += course.getCredits();
        if (st.getGPA() > 3.00) {
            if (noOfCredits_afterAdd > 21) {
                return false;
            }
        } else {
            if (noOfCredits_afterAdd > 18) {
                return false;
            }
        }


        rCourses.add(course);
        st.setCoursesRegistered(rCourses);
        return true;
    }

    public boolean deleteCourse(Course course, int st_id){
        int st_index = searchStudent(st_id);
        if (st_index == -1) return false;
        Student st = getStudent(st_index);
        ArrayList<Course> rCourses = st.getCoursesRegistered();
        int indexOfCourse = 0;
        boolean found = false;
        int noOfCredits_afterRemove = 0;
        for( int i = 0; i < rCourses.size(); i++){
            Course r = rCourses.get(i);
            noOfCredits_afterRemove += r.getCredits();
            if (r.getCourseNum().equals(course.getCourseNum())) {
                indexOfCourse = i; found = true;
            }
        }
        if (!found) return false;
        noOfCredits_afterRemove -= course.getCredits();
        if (noOfCredits_afterRemove < 12){
            System.out.println("The course can't be removed. The total no. of credits must be greater than 12 after removal");
            return false;
        } else {
            rCourses.remove(indexOfCourse);
            st.setCoursesRegistered(rCourses);
            return true;
        }
    }

    public void printStudentDetails(int st_id){
        int st_index = searchStudent(st_id);
        if (st_index == -1) {
            System.out.println("[!] No Student Information is found for the given id (" + (st_id) + ")");
            return;
        }
        Student st = getStudent(st_index);
        System.out.println("------------------------\nStudent Details:\n------------------------");
        System.out.println("ID: " + st.getIdNum());
        System.out.println("First Name: " + st.getFirstName());
        System.out.println("Last Name: " + st.getLastName());
        System.out.println("Emails: " + st.getEmail());
        System.out.println("GPA: " + st.getGPA());
        System.out.println("Gender: " + st.getGender());
        System.out.println("Advisor Number: " + st.getAdvisorNum());
        if (st.getCoursesRegistered().isEmpty()) {
            System.out.println("Courses: No Courses Registered"); return;}
        System.out.println("Courses:");
        int c = 1;
        for(Course r: st.getCoursesRegistered()){
            if (c == 1)
                System.out.println("========");
            System.out.print("[" + c + "] ");
            System.out.println("Course Number: " + r.getCourseNum());
            System.out.println("Course Name: " + r.getCourseName());
            System.out.println("Course Credits: " + r.getCredits());
            System.out.println("Course Section: " + r.getSection());
            System.out.println("========");
            c++;
        }
    }

    public void printAdvisor(int st_id){
        int st_index = searchStudent(st_id);
        if (st_index == -1) {
            System.out.println("[!] Student with ID=" + (st_id) + " is not found. No Student Advisor is found.");
            return;
        }
        Student st = getStudent(st_index);
        System.out.println("Student Advisor Number: " + st.getAdvisorNum());
    }

}
