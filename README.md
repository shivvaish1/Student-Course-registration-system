# Student-Course-registration-system

This project is a simple Student Course Registration System implemented in Java. It allows students to register for courses, view available courses, and drop courses they have registered for.

## Features

- *Course Database*: Stores course information, including course code, title, description, capacity, and schedule.
- *Student Database*: Stores student information, including student ID, name, and registered courses.
- *Course Listing*: Displays available courses with details and available slots.
- *Student Registration*: Allows students to register for courses from the available options.
- *Course Removal*: Enables students to drop courses they have registered for.

## Classes

### Course

Represents a course with attributes:
- courseCode: String
- title: String
- description: String
- capacity: int
- schedule: String
- enrolled: int (number of students enrolled)

Methods:
- registerStudent(): Registers a student to the course if capacity is not full.
- removeStudent(): Removes a student from the course if there are enrolled students.

### Student

Represents a student with attributes:
- studentID: String
- name: String
- registeredCourses: List of Course objects

Methods:
- registerCourse(Course course): Registers the student for a course.
- dropCourse(Course course): Drops the course for the student.

### CourseDatabase

Manages the collection of courses.

Methods:
- addCourse(Course course): Adds a course to the database.
- getCourse(String courseCode): Retrieves a course by its code.
- displayCourses(): Displays all courses.

### StudentDatabase

Manages the collection of students.

Methods:
- addStudent(Student student): Adds a student to the database.
- getStudent(String studentID): Retrieves a student by their ID.

### Main

Handles user interactions for course listing, registration, and removal.

## Usage

To run the project, compile and run the Main class. It provides a menu for interacting with the system:

1. Display Courses
2. Register for a Course
3. Drop a Course
4. Display students
5. Add a Course
6. Add a Student
7. Exit

### Example

1. *Display Courses*: Lists all available courses with details.
2. *Register for a Course*:
   - Enter Student ID
   - Enter Course Code
3. *Drop a Course*:
   - Enter Student ID
   - Enter Course Code
4. *Display students*: Lists all available Students with details.
5. *Add a Course*:
   - Enter Course Name
   - Enter Course ID
   - Enter Course Description
   - Enter Course Capacity
   - Enter Course Schedule
6. *Add a Student*:
   - Enter Student ID
   - Enter Student Name


## Sample Code

```java
public class Example {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        // Sample courses
        Course course1 = new Course("CS101", "Intro to Computer Science", "Basic concepts of computer science", 30, "Mon 10-12");
        Course course2 = new Course("CS102", "Data Structures", "Introduction to data structures", 25, "Wed 14-16");
        courseDatabase.addCourse(course1);
        courseDatabase.addCourse(course2);

        // Sample student
        Student student = new Student("S001", "Alice");
        studentDatabase.addStudent(student);

        // Register student for a course
        if (student.registerCourse(course1)) {
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("Course registration failed. Capacity full.");
        }

        // Display student's registered courses
        System.out.println("Registered courses for " + student.getName() + ":");
        for (Course course : student.getRegisteredCourses()) {
            System.out.println(course);
        }
    }
}