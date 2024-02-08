import java.util.ArrayList;
import java.util.HashMap;
import  java.util.List;
import java.util.Map;


public class Teacher {
    private int Id;
    private String Name;
    private List<String> Availability; // Can be 1 or more in Morning, Afternoon and Evening
    private List<Course> Teaching_Course;
    private int numberOfTeachingClass = 5;
    private Map<SchoolClass, Integer> teachingSession;

    //private int number_of_teaching_course;
    //private Schedule schedule;

    public Teacher(String name, List<String> availability, Course... teaching_Course) {
        this.Name = name;
        Availability = availability;
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

    public List<String> getAvailability() {
        return Availability;
    }

    public int getNumberOfTeachingClass() {
        return numberOfTeachingClass;
    }

    public void reduceNumberOfTeachingClass() {
        this.numberOfTeachingClass--;
    }

    public String getName() {
        return Name;
    }

    public void setClassTeachingSession(SchoolClass schoolClass, int session) {
        this.teachingSession.put(schoolClass, session);
    }

    public Integer getClassTeachingSession(SchoolClass schoolClass) {
        return teachingSession.get(schoolClass);
    }
}
