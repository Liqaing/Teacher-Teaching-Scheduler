import java.util.*;


public class Schedule_Generator {

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
    public static void assignCourse(List<SchoolClass> classes, List<Course> courses, List<Teacher> teachers, String availability) {

        if (teachers.size() < 5) {
            throw new IllegalArgumentException();
        }

        for (Course course : courses) {

            for (SchoolClass schoolClass : classes) {

                // List of teachers who can teach that course
                List<Teacher> availableTeachers = course.getTeachers(availability);

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

    // Divide teacher to see who available on when
    public static Map<String, List<Teacher>> divideTeacherOnAvailability(List<Teacher> teachers) {
        Map<String, List<Teacher>> teacherAvailability = new HashMap<>();
        for (Teacher teacher : teachers) {
            if (teacher.isMorning()) {
                addToMap(teacherAvailability, "Morning", teacher);
            }
            if (teacher.isAfternoon()) {
                addToMap(teacherAvailability, "Afternoon", teacher);
            }
            if (teacher.isEvening()) {
                addToMap(teacherAvailability, "Evening", teacher);
            }
        }
        return teacherAvailability;
    }

    // Helper method to add a teacher to the map
    private static void addToMap(Map<String, List<Teacher>> map, String key, Teacher teacher) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(teacher);
    }

    // Create morning class, afternoon, evening
    private static List<SchoolClass> generateClasses(int numberOfTeachers, String classPrefix, List<Course> courses) {
        // number of class = number of teachers

        List<SchoolClass> schoolClasses = new ArrayList<>();

        for (int i = 0; i < numberOfTeachers; i++) {
            schoolClasses.add(new SchoolClass(classPrefix + i , courses));
        }
        return schoolClasses;
    }

    // Generate schedule
    public static void generateSchedule(List<Course> courses, List<Teacher> allTeachers) {

        // Divide teacher base on availability
        Map<String, List<Teacher>> teacherAvailability = divideTeacherOnAvailability(allTeachers);

        List<Schedule> schedules = new ArrayList<>();

        for (Map.Entry<String, List<Teacher>> entry : teacherAvailability.entrySet()) {

            String availability = entry.getKey();
            List<Teacher> teachers = entry.getValue();

            // Generate class base on teacher
            List<SchoolClass> schoolClasses = generateClasses(teachers.size(), availability.substring(0, 1), courses);

            try {
                Schedule_Generator.assignCourse(schoolClasses, courses, teachers, availability);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Number of teachers in " + availability + " is only " + teachers.size() + ". You need at least 5 teacher to make valid assignment of class");
                return;
            }

            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            Integer[] periods = {1, 2};

            // Initialize new schedule
            Schedule schedule = new Schedule(availability);

            for (String day : days) {
                for (int period : periods) {

                    // Initialize new period
                    SessionPeriod sessionPeriod = new SessionPeriod();

                    // Create new session
                    Session session = new Session();

                    // List of all teachers for that time (Morning, Afternoon ...)
                    List<Teacher> availableTeachers = new ArrayList<>(teachers);

                    // For each class
                    for (SchoolClass schoolClass : schoolClasses) {

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
                System.out.println("next day" + day);
            }
            // Print schedule
            //schedule.printSchedule();
            schedules.add(schedule);
        }

        for (Schedule schedule : schedules) {
            schedule.printSchedule();
        }
    }


}
