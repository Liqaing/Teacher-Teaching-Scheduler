import java.util.*;

public class Schedule {
    // String = day (Monday, Tuesday...)
    Map<String, List<SessionPeriod>> schedule;

    public Schedule() {
        schedule = new HashMap<>();
    }

    public void addSchedulePeriod(String day, SessionPeriod sessionPeriod) {
        this.schedule.computeIfAbsent(day, k -> new ArrayList<>()).add(sessionPeriod);
    }

    public void printSchedule() {
        //String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        //Integer[] periods = {1, 2};
        // Print period 1 , 2
        // Course, class, teacher

        //System.out.println(sessions.getPeriod());
        //
        //for (String day : days) {
        //    List<SessionPeriod> sessionPeriods = schedule.get(day);
        //
        //    for (SessionPeriod sessionPeriod : sessionPeriods) {
        //        List<Session> sessions = sessionPeriod.getPeriod();
        //    }
        //
        //}

        schedule.forEach((day, sessionPeriodList) -> {
            System.out.println("Day: " + day);

            sessionPeriodList.forEach(sessionPeriod -> {
                sessionPeriod.period.forEach((periodNum, sessionList) -> {
                    System.out.println("  Period " + periodNum + ":");

                    sessionList.forEach(session -> {
                        session.getSession().forEach((schoolClass, course) ->
                                System.out.println("    Class: " + schoolClass.getClassName() +
                                        ", Course: " + course.getCourseName() +
                                        ", Teacher: " + schoolClass.getTeacherByCourse(course).getTeacherName()));
                    });
                });
            });

            System.out.println(); // Add a line break between days
        });
    }
}

class SessionPeriod {
    Map<Integer, List<Session>> period;

    public SessionPeriod() {
        this.period = new HashMap<>();
    }

    public void addSessionPeriod(int period, Session session) {
        this.period.computeIfAbsent(period, k -> new ArrayList<>()).add(session);
    }

    public List<Session> getPeriod(int periodNum) {
        return period.get(periodNum);
    }

}

// Map school class to course
class Session {
    Map<SchoolClass, Course> session;

    public Session() {
        this.session = new HashMap<>();
    }

    public void addSession(SchoolClass schoolClass, Course course) {
        this.session.put(schoolClass, course);
    }

    public Map<SchoolClass, Course> getSession() {
        return session;
    }
}