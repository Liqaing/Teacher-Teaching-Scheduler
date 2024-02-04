import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class SchoolClass {
    private String className;
    private Schedule classSchedule;

    private Map<Course, Teacher> assignedTeacher;

    public SchoolClass(String className, List<Course> courses) {
        this.className = className;
        this.assignedTeacher = new HashMap<>();
        for (Course course : courses) {
            assignedTeacher.put(course, null);
        }
    }

    public void assignTeacher(Course course, Teacher teacher) {
        assignedTeacher.put(course, teacher);
    }

    public Teacher getAssignedTeacher(Course course) {
        return assignedTeacher.get(course);
    }

    // Check if all course have teacher
    public boolean areAllTeacherAssigned() {
        for (Teacher teacher : assignedTeacher.values()) {
            if (teacher == null) {
                return false;
            }
        }
        return true;
    }

    // Check if a teacher have been assign this class already
    public boolean isTheTeacherAssigned(Teacher teacher) {
        for (Teacher assignedTeacher : assignedTeacher.values()) {
            if (assignedTeacher == teacher) {
                return true;
            }
        }
        return false;
    }

    public Map<Course, Teacher> getAssignedTeacher() {
        return assignedTeacher;
    }
}
