import java.util.*;

class Student{
    int id;
    String name;
    int age;
    HashSet<String> courses = new HashSet<>();

    Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    Student(int id, String name, int age, String course){
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses.add(course);
    }

    void addCourse(String course){
        courses.add(course);
    }

    void removeCourse(String course){
        courses.remove(course);
    }

    void updateCourse(String oldCourse, String newCourse){
        courses.remove(oldCourse); courses.add(newCourse);
    }

    void displayDetails(){
        System.out.printf("ID: %d, Name: %s, Age: %d, Courses: %s\n",id, name, age, courses);
    }
}


public class StudentManagementSystem {

    HashMap<Integer,Student> students = new HashMap<>();

    void addStudent(Student student){
        students.put(student.id, student);
    }

    void addStudent(int id, String name, int age){
        Student student = new Student(id,name,age);
        students.put(id, student);
    }

    void addStudent(int id, String name, int age, String course){
        Student student = new Student(id,name,age,course);
        students.put(id, student);
    }

    void removeStudent(int id){
        students.remove(id);
    }

    void updateStudentData(int id, String name){
        if (students.get(id) != null){
            students.get(id).name = name;
        }
        else{
            System.out.println("no such id");
        }
    }

    void updateStudentData(int id, int age){
        if (students.get(id) != null){
            students.get(id).age = age;
        }
        else{
            System.out.println("no such id");
        }
    }

    void updateStudentCourse(int id, String oldCourse, String newCourse){
        if (students.get(id) != null){
            students.get(id).updateCourse(oldCourse, newCourse);
        }
        else{
            System.out.println("no such id");
        }
    }

    void updateStudentCourse(int id, String course){
        if (students.get(id) != null){
            students.get(id).addCourse(course);
        }
        else{
            System.out.println("no such id");
        }
    }

    void displayStudentData(int id){
        if (students.get(id) != null){
            students.get(id).displayDetails();
        }
        else System.out.println("no such id");
    }

    void displayAllStudents(){
        TreeMap<Integer, Student> sortedStudents = new TreeMap<>(students);
        for (Map.Entry<Integer, Student> entry: sortedStudents.entrySet()){
            System.out.print("ID: "+entry.getKey() + " ");
            entry.getValue().displayDetails();
        }
    }

    void listStudentsByCourse(String course){
        for (Student student : students.values()){
            if (student.courses.contains(course)){
                System.out.println(student.name);
            }
        }
    }


    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Student bek = new Student(1093, "Bekbolsun", 17);
        sms.addStudent(bek);
        sms.addStudent(325,"Umarbek", 18);
        sms.addStudent(632,"Nurmuhammed", 17, "Singing");

        sms.removeStudent(1093);

        sms.updateStudentData(325, "Umar");
        sms.updateStudentData(325, 19);

        sms.updateStudentCourse(632, "Make-up");
        sms.updateStudentCourse(325, "Boxing"); //Just adds
        sms.updateStudentCourse(325, "Yoga"); 
        sms.updateStudentCourse(325, "Boxing", "Dancing"); //Changes boxing to dancing

        sms.displayStudentData(1093);
        sms.displayStudentData(325);

        System.out.println("All Students:");
        sms.displayAllStudents();
    }
}
