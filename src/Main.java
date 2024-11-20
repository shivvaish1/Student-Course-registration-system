import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        courseDatabase.addCourse(new Course("CS101", "Intro to Computer Science", "Basic concepts of computer science", 30, "Mon 10-12"));
        courseDatabase.addCourse(new Course("CS102", "Data Structures", "Introduction to data structures", 25, "Wed 14-16"));

        studentDatabase.addStudent(new Student("S001", "Tushar"));
        studentDatabase.addStudent(new Student("S002", "Shubham"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Display students");
            System.out.println("5. Add a Student");
            System.out.println("6. Add a course");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    courseDatabase.displayCourses();
                    break;
                case 2:
                    System.out.println("Enter Student ID: ");
                    String studentID = scanner.next();
                    Student student = studentDatabase.getStudent(studentID);
                    if (student != null) {
                        System.out.println("Enter Course Code: ");
                        String courseCode = scanner.next();
                        Course course = courseDatabase.getCourse(courseCode);
                        if (course != null) {
                            if (student.registerCourse(course)) {
                                System.out.println("Course registered successfully.");
                            } else {
                                System.out.println("Course registration failed. Capacity full.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Student ID: ");
                    studentID = scanner.next();
                    student = studentDatabase.getStudent(studentID);
                    if (student != null) {
                        System.out.println("Enter Course Code: ");
                        String courseCode = scanner.next();
                        Course course = courseDatabase.getCourse(courseCode);
                        if (course != null) {
                            if (student.dropCourse(course)) {
                                System.out.println("Course dropped successfully.");
                            } else {
                                System.out.println("Course drop failed.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    studentDatabase.displayStudents();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter Student ID: ");
                    String newStudentId = scanner.nextLine();
                    System.out.println("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    studentDatabase.addStudent(new Student(newStudentId, studentName));
                    break;
                case 6 :
                    scanner.nextLine();
                    System.out.println("Enter Course ID: ");
                    String newCourseId = scanner.nextLine();
                    System.out.println("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.println("Enter Course Description: ");
                    String courseDescription = scanner.nextLine();
                    System.out.println("Enter Course Capacity: ");
                    int courseCapacity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Course Schedule: ");
                    String courseSchedule = scanner.nextLine();
                    courseDatabase.addCourse(new Course(newCourseId, courseName, courseDescription, courseCapacity, courseSchedule));
                    break;
                
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}