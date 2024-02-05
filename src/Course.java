import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

public class Course {
    private String courseName;
    private List<Teacher> teachers;

    public Course(String courseName) {
        this.courseName = courseName;
        this.teachers = new ArrayList<>();
    }

    // Add teacher who teach this course
    public void addTeacher(Teacher teacher) {
        if(!teachers.contains(teacher)) {
            this.teachers.add(teacher);
        }
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public String getCourseName() {
        return courseName;
=======

public class Course {
    private String courseName;
    private ArrayList<Teacher> teachers;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addTeachers(Teacher teachers) {
        this.teachers.add(teachers);
>>>>>>> origin/algorithms
    }
}
