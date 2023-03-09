import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudentSystem() {
        ArrayList<Student> list = new ArrayList<>();
        loop: while (true) {
            System.out.println("-----Welcome to student's system-----");
            System.out.println("1: Add student");
            System.out.println("2: Delete student");
            System.out.println("3: Update student");
            System.out.println("4: Search student");
            System.out.println("5: Exit");
            System.out.println("Please enter the number: ");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> searchStudent(list);
                case "5" -> {
                    System.out.println("Exit");
                    // break loop;
                    System.exit(0); // stop the VRM
                }
                default -> System.out.println("No option");
            }
        }
    }

    // add student
    public static void addStudent(ArrayList<Student> list) {
//        System.out.println("Add student");
        // create a Student object
        Student student = new Student();

        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("Please enter student's id");
            id = sc.next();

            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("This id already exists, please enter a new one:");
            } else {
                student.setId(id);
                break;
            }
        }

        System.out.println("Please enter student's name");
        String name = sc.next();
        student.setName(name);

        System.out.println("Please enter student's age");
        int age = sc.nextInt();
        student.setAge(age);

        System.out.println("Please enter student's address");
        String address = sc.next();
        student.setAddress(address);

        list.add(student);

        System.out.println("The information is added successfully");
    }

    // delete student
    public static void deleteStudent(ArrayList<Student> list) {
//        System.out.println("Delete student");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the id need to delete:");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("Students with ID " + id + " have been deleted");
        } else {
            System.out.println("Delete failed, the id does not exist");
        }
    }

    // update student
    public static void updateStudent(ArrayList<Student> list) {
//        System.out.println("Update student");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the student's id which you want to update:");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("Update failed, the id does not exist, please enter a new one");
            return;
        }

        Student stu = list.get(index);

        System.out.println("Please enter the student's new name:");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("Please enter the student's new age: ");
        int newAge = sc.nextInt();
        stu.setAge(newAge);

        System.out.println("Please enter the student's new address:");
        String newAddress = sc.next();
        stu.setAddress(newAddress);

        System.out.println("Update student's info successfully");
    }

    // search student
    public static void searchStudent(ArrayList<Student> list) {
        // System.out.println("Search student");
        if (list.size() == 0) {
            System.out.println("No student, please add student");
            return;
        }

        System.out.println("id\t\tname\tage\taddress");
        for (Student stu : list) {
            System.out.println(stu.getId() + " \t" + stu.getName() + " \t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    // Judge whether the id already exists
    public static boolean contains(ArrayList<Student> list, String id) {

        return getIndex(list, id) >= 0;
    }

    // Get id through index
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if (sid.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
