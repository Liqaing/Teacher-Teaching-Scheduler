import  java.util.List;
import java.util.Random;

public class Schedule_Generator {

    // number of class = number of teacher
    private int numOfClass = 5;

    public static void sort() {

    }

    // Get random index from list
    private static <T> T getRandomElement(List<T> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    // For each class, assign teacher to course
    public static void assignCourse(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers) {

        for (SchoolClass schoolClass : classes) {

            // While class still not have all teacher
            while (!schoolClass.areAllTeacherAssigned()) {
                Course course = getRandomElement(courses);
                // If no teacher have been assign to the course yet
                if (schoolClass.getAssignedTeacher(course) == null) {
                    // Pick a random teacher
                    Teacher teacher = getRandomElement(teachers);
                    // If teacher can take more classes and he have not been assign to the class yet
                    if (teacher.getNumberOfTeachingClass() > 0 && !schoolClass.isTheTeacherAssigned(teacher)) {
                        // Assign the teacher
                        schoolClass.assignTeacher(course, teacher);
                    }
                }
            }
        }
    }


}
