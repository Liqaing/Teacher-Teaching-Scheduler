import java.util.ArrayList;
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

    public List<Teacher> getTeachers(String availability) {
        List<Teacher> availableTeachers = new ArrayList<>();

        // Get only teacher whi available in certain time
        if (availability.equals("Morning")) {
            for (Teacher teacher : teachers) {
                if (teacher.isMorning()) {
                    availableTeachers.add(teacher);
                }
            }
        }
        else if (availability.equals("Afternoon")) {
            for (Teacher teacher : teachers) {
                if (teacher.isAfternoon()) {
                    availableTeachers.add(teacher);
                }
            }
        }
        else if (availability.equals("Evening")) {
            for (Teacher teacher : teachers) {
                if (teacher.isEvening()) {
                    availableTeachers.add(teacher);
                }
            }
        }

        return availableTeachers;
    }

    public String getCourseName() {
        return courseName;
    }


}
