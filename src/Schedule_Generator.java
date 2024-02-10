import java.util.*;


public class Schedule_Generator {

    // number of class = number of teacher
    private int numOfClass = 5;

    //public static void sort() {
    //
    //}

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
                }
                // If teacher already teach 5 class
                while (teacher.getNumberOfTeachingClass() <= 0) {

                    if (availableTeachers != null) {
                        availableTeachers.remove(teacher);
                    }

                    try {
                        teacher = getRandomElement(availableTeachers);
                    }
                    catch (IllegalArgumentException e) {
                        teacher = getRandomElement(teachers);
                    }
                }

                // If teacher has been assign to the class yet
                while (schoolClass.isTheTeacherAssigned(teacher)) {

                    if (availableTeachers != null) {
                        availableTeachers.remove(teacher);
                    }

                    try {
                        teacher = getRandomElement(availableTeachers);
                    }
                    catch (IllegalArgumentException e) {
                        teacher = getRandomElement(teachers);
                    }
                }

                // If no teacher have been assign to that course yet
                if (schoolClass.getAssignedTeacher(course) == null) {

                    // Assign the teacher
                    schoolClass.assignTeacher(course, teacher);
                    teacher.setClassTeachingSession(schoolClass, 2);
                    teacher.reduceNumberOfTeachingClass();
//                    System.out.println(teacher.getName() + " teach class " + schoolClass.getClassName() + " " + course.getCourseName() + " session: " + teacher.getClassTeachingSession(schoolClass));
                }
            }

        }
    }

    // Generate schedule
    public static void generateSchedule(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers) {

        Schedule_Generator.assignCourse(classes, courses, teachers);

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Integer[] periods = {1, 2};

        // Initialize new schedule
        Schedule schedule = new Schedule();

        for (String day : days) {
            for (int period : periods) {

                // Initialize new period
                SessionPeriod sessionPeriod = new SessionPeriod();

                // Create new session
                Session session = new Session();

                // List of all teachers
                List<Teacher> availableTeachers = new ArrayList<>(teachers);

                // For each class
                for (SchoolClass schoolClass : classes) {

                    Teacher teacher = getRandomElement(schoolClass.getAllTeachers());

                    // If teacher not available
                    while (!availableTeachers.contains(teacher)) {
                        teacher = getRandomElement(schoolClass.getAllTeachers());
                    }

                    // If he/she have already teaches that class 2 session
                    while (teacher.getClassTeachingSession(schoolClass) <= 0) {
                        teacher = getRandomElement(schoolClass.getAllTeachers());
                    }

                    // What course he/she teach
                    Course course = schoolClass.getCourseByTeacher(teacher);

                    // Create new session and map class to course

                    session.addSession(schoolClass, course);

                    // Teacher is no longer available for this period
                    availableTeachers.remove(teacher);

                    //System.out.println(period + " " + schoolClass.getClassScheduleByDay(day).get(period).getTeachers());
                }
                // Add session to period
                sessionPeriod.addSessionPeriod(period, session);

                // Add to schedule
                schedule.addSchedulePeriod(day, sessionPeriod);
            }
        }
        // Print schedule
        schedule.printSchedule();
    }


}
