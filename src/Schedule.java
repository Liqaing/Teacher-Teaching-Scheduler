import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Schedule {
    Map<String, Map<Integer, Course>> schedule;

    public Schedule() {
        schedule = new HashMap<>();
    }

    public void setSchedulePeriod(String day, Map<Integer, Course> periodCourse) {
        this.schedule.put(day, periodCourse);
    }

    public Map<Integer, Course> getScheduleByDay(String day) {
        Map<Integer, String> scheduleForPeriod = new HashMap<>();
        Map<Integer, Course> periodCourse = schedule.get(day);
        scheduleForPeriod.put(periodCourse.)
        return schedule.get(day);
    }
}
