import java.util.ArrayList;
import  java.util.List;

public class Teacher {
    private int Id;
    private String Name;
    private List<String> Availability; // Can be 1 or more in Morning, Afternoon and Evening
    private List<Course> Teaching_Course;
    private int numberOfTeachingClass = 5;

    private int number_of_teaching_course;
    //private Course[] Course;
    private Schedule schedule;

    public Teacher(String name, List<String> availability, Course... teaching_Course) {
        this.Name = name;
        Availability = availability;
        this.Teaching_Course = new ArrayList<>();
        for (Course course : teaching_Course) {
            this.Teaching_Course.add(course);
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
}
