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
        Teacher Thy = new Teacher("Thy", true, true, true, cSharp, statistic);
        Teacher Jack = new Teacher("Jack", true, true, true, java, statistic);
        Teacher Rose = new Teacher("Rose", true, true, true, cSharp, isad);
        Teacher Mendeleev = new Teacher("Mendeleev", false, true, false, cSharp, isad);
        Teacher Xavier = new Teacher("Xavier", true, false, true, java, network);
        Teacher RichardFeynman = new Teacher("Richard Feynman", false, false, true, statistic, network);
        Teacher John = new Teacher("John", true, true, true, network, isad);

        Teacher a = new Teacher("a", false, false, true, network, cSharp);
        Teacher b = new Teacher("b", false, false, true, java, isad);
        Teacher c = new Teacher("c", false, false, true, network, statistic);
        Teacher d = new Teacher("d", false, false, true, statistic, isad);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(RichardFeynman);
        teachers.add(Mendeleev);
        teachers.add(Thy);
        teachers.add(Jack);
        teachers.add(Rose);
        teachers.add(Xavier);
        teachers.add(John);
        teachers.add(a);
        teachers.add(b);
        teachers.add(c);
        teachers.add(d);


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
        //SchoolClass E1 = new SchoolClass("E1", courses);
        //SchoolClass E2 = new SchoolClass("E2", courses);
        //SchoolClass E3 = new SchoolClass("E3", courses);
        //SchoolClass E4 = new SchoolClass("E4", courses);
        //SchoolClass E5 = new SchoolClass("E5", courses);
        //
        //List<SchoolClass> classes = new ArrayList<>();
        //classes.add(E1);
        //classes.add(E2);
        //classes.add(E3);
        //classes.add(E4);
        //classes.add(E5);

        Schedule_Generator.generateSchedule(courses, teachers);

        //for (SchoolClass myClass : classes) {
        //    System.out.println(myClass.getAssignedTeacher().get(java).getName());
        //}

    }

}
