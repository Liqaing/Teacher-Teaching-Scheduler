import java.util.ArrayList;
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
        this.classSchedule = new Schedule();
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

    public String getClassName() {
        return className;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>(assignedTeacher.values());
        return teachers;
    }

    public Course getCourseByTeacher(Teacher teacher) {
        for (Map.Entry<Course, Teacher> entry : assignedTeacher.entrySet()) {
            if (entry.getValue().equals(teacher)) {
                return entry.getKey();
            }
        }
        return null; // Return null if the teacher is not found
    }

    public void setClassSchedule(String day, Map<Integer, Course> periodCourse) {
        this.classSchedule.setSchedulePeriod(day, periodCourse);
    }

    public Map<Integer, Course> getClassScheduleByDay(String day) {
        return classSchedule.getScheduleByDay(day);
    }
}
