import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // Example schedule
        Map<Integer, Map<String, Map<Integer, ScheduleEntry>>> schedule = new HashMap<>();

        // Populate the schedule with sample data
        schedule.put(1, createDaySchedule());
        schedule.put(2, createDaySchedule());
        // ... add more days if needed

        // Print the schedule
        printSchedule(schedule);
    }

    // Helper method to create a sample day schedule
    private static Map<String, Map<Integer, ScheduleEntry>> createDaySchedule() {
        Map<String, Map<Integer, ScheduleEntry>> daySchedule = new HashMap<>();

        // Sample class names
        String[] classNames = {"Class A", "Class B", "Class C", "Class D", "Class E"};

        for (String className : classNames) {
            daySchedule.put(className, createClassSchedule());
        }

        return daySchedule;
    }

    // Helper method to create a sample class schedule
    private static Map<Integer, ScheduleEntry> createClassSchedule() {
        Map<Integer, ScheduleEntry> classSchedule = new HashMap<>();

        // Sample periods
        int periodsPerDay = 2;

        for (int period = 1; period <= periodsPerDay; period++) {
            classSchedule.put(period, new ScheduleEntry("Teacher", "Course"));
        }

        return classSchedule;
    }

    // Helper method to print the schedule
    private static void printSchedule(Map<Integer, Map<String, Map<Integer, ScheduleEntry>>> schedule) {
        for (Map.Entry<Integer, Map<String, Map<Integer, ScheduleEntry>>> entry : schedule.entrySet()) {
            int day = entry.getKey();
            System.out.println("Day " + day + " Schedule:");

            for (Map.Entry<String, Map<Integer, ScheduleEntry>> classEntry : entry.getValue().entrySet()) {
                String className = classEntry.getKey();
                System.out.println(className + " Schedule:");

                for (Map.Entry<Integer, ScheduleEntry> periodEntry : classEntry.getValue().entrySet()) {
                    int period = periodEntry.getKey();
                    ScheduleEntry scheduleEntry = periodEntry.getValue();

                    System.out.println("  Period " + period + ": " +
                            "Teacher: " + scheduleEntry.teacher + ", " +
                            "Course: " + scheduleEntry.course);
                }
            }
            System.out.println();
        }
    }
}

// Class representing a schedule entry
class ScheduleEntry {
    String teacher;
    String course;

    public ScheduleEntry(String teacher, String course) {
        this.teacher = teacher;
        this.course = course;
    }
}

