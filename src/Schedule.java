import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Schedule {
    // String = day (Monday)
    Map<String, SessionPeriod> schedule;

    public Schedule() {
        schedule = new HashMap<>();
    }

    public void addSchedulePeriod(String day, SessionPeriod sessionPeriod) {
        this.schedule.put(day, sessionPeriod);
    }

    public void printSchedule() {
        //String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        //Integer[] periods = {1, 2};
        //for (String day : days) {
        //    for (int period : periods) {
        //        SessionPeriod todaySchedule = schedule.get(day);
        //
        //        Session session = todaySchedule.getPeriod(period);
        //        Map<SchoolClass, Course> a = session.getSession();
        //        System.out.println();
        //        // Print period 1 , 2
        //        // Course, class, teacher
        //
        //    }
        //}
        System.out.println(schedule);
    }
}

class SessionPeriod {
    Map<Integer, Session> period;

    public SessionPeriod() {
        this.period = new HashMap<>();
    }

    public void addSessionPeriod(int period, Session session) {
        this.period.put(period, session);
    }

    public Session getPeriod(int periodNum) {
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