package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.CourseDao;
import mthree.com.fullstackschool.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {

    //YOUR CODE STARTS HERE

    // DAO is injected through the constructor 
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    //YOUR CODE ENDS HERE

    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE

        // Pass through to the DAO, which returns every course in the database
        return courseDao.getAllCourses();

        //YOUR CODE ENDS HERE
    }

    public Course getCourseById(int id) {
        //YOUR CODE STARTS HERE

        try {
            return courseDao.findCourseById(id);
        } catch (DataAccessException ex) {
            // No row for this id return a placeholder course instead of throwing
            Course course = new Course();
            course.setCourseName("Course Not Found");
            course.setCourseDesc("Course Not Found");
            return course;
        }

        //YOUR CODE ENDS HERE
    }

    public Course addNewCourse(Course course) {
        //YOUR CODE STARTS HERE

        // Reject blank name or description without touching the database
        if (course.getCourseName().trim().isEmpty() || course.getCourseDesc().trim().isEmpty()) {
            course.setCourseName("Name blank, course NOT added");
            course.setCourseDesc("Description blank, course NOT added");
            return course;
        }
        return courseDao.createNewCourse(course);

        //YOUR CODE ENDS HERE
    }

    public Course updateCourseData(int id, Course course) {
        //YOUR CODE STARTS HERE

        // The id in the URL must match the id in the request body
        if (id != course.getCourseId()) {
            course.setCourseName("IDs do not match, course not updated");
            course.setCourseDesc("IDs do not match, course not updated");
            return course;
        }
        courseDao.updateCourse(course);
        return course;

        //YOUR CODE ENDS HERE
    }

    public void deleteCourseById(int id) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }
}
