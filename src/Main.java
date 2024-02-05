import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // List of course
        Course java = new Course("Java");
        Course cSharp = new Course("C#");
        Course statistic = new Course("Statistic");
        Course network = new Course("Network");
        Course isad = new Course("ISAD");

        List<Course> courses = new ArrayList<>();
        courses.add(java);
        courses.add(cSharp);
        courses.add(statistic);
        courses.add(network);
        courses.add(isad);

        // Teacher
        Teacher Thy = new Teacher("Thy", Arrays.asList("morning"), cSharp, statistic);
        Teacher Jack = new Teacher("Jack", Arrays.asList("morning"), java, statistic);
        Teacher Rose = new Teacher("Rose", Arrays.asList("morning"), cSharp, isad);
        Teacher Xavier = new Teacher("Xavier", Arrays.asList("morning"), java, network);
        Teacher John = new Teacher("John", Arrays.asList("morning"), network, isad);

        List<Teacher> teacher = new ArrayList<>();
        teacher.add(Thy);
        teacher.add(Jack);
        teacher.add(Rose);
        teacher.add(Xavier);
        teacher.add(John);

//        Print course teacher
//        System.out.println(java.getTeachers());
//        for (Teacher teachera : java.getTeachers()) {
//            System.out.println(teachera.getName());
//        }

//      print teacher course
//        for (Course coursea : Thy.getTeaching_Course()) {
//            System.out.println(coursea.getCourseName());
//        }

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

        //Schedule_Generator.assignCourse(classes, courses, teacher);
        //for (SchoolClass myClass : classes) {
        //    System.out.println(myClass.getAssignedTeacher().get(java).getName());
        //}

    }

}
