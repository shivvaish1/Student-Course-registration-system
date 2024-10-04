import java.util.HashMap;
import java.util.Map;

public class CourseDatabase {
    private Map<String, Course> courses;

    public CourseDatabase() {
        this.courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseCode(), course);
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public void displayCourses() {
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }
}