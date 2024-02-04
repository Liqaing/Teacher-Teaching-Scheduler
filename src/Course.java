import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Teacher> teachers;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addTeachers(Teacher teachers) {
        this.teachers.add(teachers);
    }
}
