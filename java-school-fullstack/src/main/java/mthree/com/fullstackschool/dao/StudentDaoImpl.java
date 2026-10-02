package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.StudentMapper;
import mthree.com.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.*;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Student createNewStudent(Student student) {
        //YOUR CODE STARTS HERE


        return null;


        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        // StudentMapper converts each row of the result set into a Student.
        final String sql = """
                           SELECT *
                           FROM student
                           """;

        return jdbcTemplate.query(sql, new StudentMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Student findStudentById(int id) {
        //YOUR CODE STARTS HERE

        // ? is a placeholder for a value that will be supplied later.
        final String sql = """
                           SELECT *
                           FROM student
                           WHERE sid = ?
                           """;

        return jdbcTemplate.queryForObject(sql, new StudentMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateStudent(Student student) {
        //YOUR CODE STARTS HERE

        // The arguments fill the ? placeholders in order, so sid goes last.
        final String sql = """
                           UPDATE student
                           SET fName = ?, lName = ?
                           WHERE sid = ?
                           """;

        jdbcTemplate.update(sql,
                student.getStudentFirstName(),
                student.getStudentLastName(),
                student.getStudentId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudent(int id) {
        //YOUR CODE STARTS HERE

        // Remove the student's enrolments first so no course_student rows are left
        // pointing at a student that no longer exists.
        final String enrolmentSql = """
                                    DELETE FROM course_student
                                    WHERE student_id = ?
                                    """;

        jdbcTemplate.update(enrolmentSql, id);

        // DELETE also goes through update(), since it changes data and returns no rows.
        final String sql = """
                           DELETE FROM student
                           WHERE sid = ?
                           """;

        jdbcTemplate.update(sql, id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE



        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        // Removes the enrolment only; the student and the course themselves stay.
        final String sql = """
                           DELETE FROM course_student
                           WHERE student_id = ? AND course_id = ?
                           """;

        jdbcTemplate.update(sql, studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}
