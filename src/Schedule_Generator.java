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

//    private static void addTeacherToCourse(List<Course> courses, List<Teacher> teachers) {
//        for (Teacher teacher : teachers) {
//            // List of courses which teacher can teach
//            List<Course> teachingCourse = teacher.getTeaching_Course();
//            for (Course course : teachingCourse) {
//
//            }
//        }
//    }

    // For each class, assign teacher to coursea
    public static void assignCourse(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers) {

        for (SchoolClass schoolClass : classes) {

            // While class still not have all teacher
            for (Course course : courses) {

                // If no teacher have been assign to that course yet
                while (schoolClass.getAssignedTeacher(course) == null) {

                    // Pick a random teacher who can teach that course
                    Teacher teacher = getRandomElement(course.getTeachers());

                    // If teacher can take more classes and he have not been assign to the class yet
                    if (teacher.getNumberOfTeachingClass() > 0 && !schoolClass.isTheTeacherAssigned(teacher)) {

                        // Assign the teacher
                        schoolClass.assignTeacher(course, teacher);
                        System.out.println(teacher.getName());
                    }

                }
            }
        }
    }


}
