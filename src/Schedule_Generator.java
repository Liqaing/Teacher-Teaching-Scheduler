import java.util.ArrayList;
import  java.util.List;
import java.util.Random;

public class Schedule_Generator {

    // number of class = number of teacher
    private int numOfClass = 5;

    public static void sort() {

    }

    // Get random index from list
    private static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    // For each class, assign teacher to courses
    public static void assignCourse(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers) {

        for (Course course : courses) {

            for (SchoolClass schoolClass : classes) {

                // List of teachers who can teach that course
                List<Teacher> availableTeachers = course.getTeachers();

                // Pick random teacher
                Teacher teacher;
                if (availableTeachers == null || availableTeachers.isEmpty()) {
                    teacher = getRandomElement(teachers);
                }
                else {
                    teacher = getRandomElement(availableTeachers);

                    // If teacher already teach 5 class
                    while (teacher.getNumberOfTeachingClass() <= 0) {
                        availableTeachers.remove(teacher);
                        try {
                            teacher = getRandomElement(availableTeachers);
                        }
                        catch (IllegalArgumentException e) {
                            teacher = getRandomElement(teachers);
                        }
                    }

                    // If teacher has been assign to the class yet
                    while (schoolClass.isTheTeacherAssigned(teacher)) {
                        availableTeachers.remove(teacher);
                        try {
                            teacher = getRandomElement(availableTeachers);
                        }
                        catch (IllegalArgumentException e) {
                            teacher = getRandomElement(teachers);
                        }
                    }
                }

                // If no teacher have been assign to that course yet
                if (schoolClass.getAssignedTeacher(course) == null) {

                    // Assign the teacher
                    schoolClass.assignTeacher(course, teacher);
                    teacher.setClassTeachingSession(schoolClass, 2);
                    teacher.reduceNumberOfTeachingClass();
                    System.out.println(teacher.getName() + " teach class " + schoolClass.getClassName() + " " + course.getCourseName() + " session: " + teacher.getClassTeachingSession(schoolClass));
                }
            }

        }
    }

    // Generate schedule
    public static void generateSchedule(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Integer[] periods = {1, 2};

        for (String day : days) {
            for (Integer period : periods) {

                // List of all teachers
                List<Teacher> availableTeachers = new ArrayList<>(teachers);

                // For each class
                for (SchoolClass schoolClass : classes) {
                    Teacher teacher = getRandomElement(schoolClass.getAllTeachers());

                }
            }
        }
    }


}
