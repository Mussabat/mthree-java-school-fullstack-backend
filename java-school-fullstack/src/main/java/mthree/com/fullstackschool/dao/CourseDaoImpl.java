package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.CourseMapper;
import mthree.com.fullstackschool.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private final JdbcTemplate jdbcTemplate;

    public CourseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course createNewCourse(Course course) {
        //YOUR CODE STARTS HERE


        return null;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE

       // CourseMapper converts each row of the result set into a Course.

         final String sql = """
                            SELECT * 
                            FROM course
                            """;

        return jdbcTemplate.query(sql, new CourseMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Course findCourseById(int id) {
        //YOUR CODE STARTS HERE

        // ? is a placeholder for a value that will be supplied later.
        final String sql = """
                           SELECT *
                           FROM course
                           WHERE cid = ?
                           """;

        return jdbcTemplate.queryForObject(sql, new CourseMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateCourse(Course course) {
        //YOUR CODE STARTS HERE

        // The arguments fill the ? placeholders in order, so cid goes last.
        // No CourseMapper here: UPDATE returns no rows, so there is nothing to map.
        
        final String sql = """
                           UPDATE course
                           SET courseCode = ?, courseDesc = ?, teacherId = ?
                           WHERE cid = ?
                           """;

        jdbcTemplate.update(sql,
                course.getCourseName(),
                course.getCourseDesc(),
                course.getTeacherId(),
                course.getCourseId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteCourse(int id) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteAllStudentsFromCourse(int courseId) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }
}
