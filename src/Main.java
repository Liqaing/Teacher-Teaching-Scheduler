import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // List of course
        Course java = new Course("Java");
        Course CSharp = new Course("C#");
        Course Statistic = new Course("Statistic");
        Course Network = new Course("Network");
        Course Isad = new Course("ISAD");

        List<Course> courses = new ArrayList<>();
        courses.add(java);
        courses.add(CSharp);
        courses.add(Statistic);
        courses.add(Network);
        courses.add(Isad);

        // Teacher
        Teacher Thy = new Teacher("Thy", Arrays.asList("morning"), courses.get(1), courses.get(2));
        Teacher Jack = new Teacher("Jack", Arrays.asList("morning"), courses.get(0), courses.get(2));
        Teacher Rose = new Teacher("Rose", Arrays.asList("morning"), courses.get(1), courses.get(4));
        Teacher Xavier = new Teacher("Xavier", Arrays.asList("morning"), courses.get(0), courses.get(3));
        Teacher John = new Teacher("John", Arrays.asList("morning"), courses.get(3), courses.get(4));

        List<Teacher> teacher = new ArrayList<>();
        teacher.add(Thy);
        teacher.add(Jack);
        teacher.add(Rose);
        teacher.add(Xavier);
        teacher.add(John);


        // List of class
        SchoolClass E1 = new SchoolClass("E1", courses);
        SchoolClass E2 = new SchoolClass("E2", courses);
        SchoolClass E3 = new SchoolClass("E3", courses);
        SchoolClass E4 = new SchoolClass("E4", courses);
        SchoolClass E5 = new SchoolClass("E5", courses);

        List<SchoolClass> classes = new ArrayList<>();
        classes.add(E1);
        classes.add(E2);
        classes.add(E3);
        classes.add(E4);
        classes.add(E5);

        Schedule_Generator.assignCourse(classes, courses, teacher);
        for (SchoolClass myClass : classes) {
            System.out.println(myClass.getAssignedTeacher().get(java).getName());
        }

    }

}
