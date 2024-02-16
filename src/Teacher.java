import java.util.ArrayList;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;


public class Teacher {
    private int Id;
    private String Name;
    //private List<String> Availability; // Can be 1 or more in Morning, Afternoon and Evening
    private List<Course> Teaching_Course;
    private int numberOfTeachingClass;
    private Map<SchoolClass, Integer> teachingSession;

    private boolean isMorning;
    private boolean isAfternoon;
    private boolean isEvening;

    public Teacher(String name, boolean isMorning, boolean isAfternoon, boolean isEvening, Course... teaching_Course) {
        this.Name = name;
        this.isMorning = isMorning;
        this.isAfternoon = isAfternoon;
        this.isEvening = isEvening;

        // Number of class he/she teaches increase depend on how many times he/she teaches
        if (this.isMorning) {
            numberOfTeachingClass += 5;
        }
        if (this.isAfternoon) {
            numberOfTeachingClass += 5;
        }
        if (this.isEvening) {
            numberOfTeachingClass += 5;
        }

        this.teachingSession = new HashMap<>();
        this.Teaching_Course = new ArrayList<>();
        for (Course course : teaching_Course) {
            this.Teaching_Course.add(course);

            // Add this teacher to course
            course.addTeacher(this);
        }
    }

    public List<Course> getTeaching_Course() {
        return Teaching_Course;
    }

    public int getNumberOfTeachingClass() {
        return numberOfTeachingClass;
    }

    public void reduceNumberOfTeachingClass() {
        this.numberOfTeachingClass--;
    }

    public String getTeacherName() {
        return Name;
    }

    public void setClassTeachingSession(SchoolClass schoolClass, int session) {
        this.teachingSession.put(schoolClass, session);
    }

    public Integer getClassTeachingSession(SchoolClass schoolClass) {
        return teachingSession.get(schoolClass);
    }

    public boolean isMorning() {
        return isMorning;
    }

    public boolean isAfternoon() {
        return isAfternoon;
    }

    public boolean isEvening() {
        return isEvening;
    }

}
