package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.TeacherMapper;
import mthree.com.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE

        return null;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE

        // TeacherMapper converts each row of the result set into a Teacher.
        final String sql = """
                           SELECT *
                           FROM teacher
                           """;

        return jdbcTemplate.query(sql, new TeacherMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Teacher findTeacherById(int id) {
        //YOUR CODE STARTS HERE

        // ? is a placeholder for a value that will be supplied later.
        final String sql = """
                           SELECT *
                           FROM teacher
                           WHERE tid = ?
                           """;

        return jdbcTemplate.queryForObject(sql, new TeacherMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateTeacher(Teacher t) {
        //YOUR CODE STARTS HERE

        // The arguments fill the ? placeholders in order, so tid goes last.
        final String sql = """
                           UPDATE teacher
                           SET tFName = ?, tLName = ?, dept = ?
                           WHERE tid = ?
                           """;

        jdbcTemplate.update(sql,
                t.getTeacherFName(),
                t.getTeacherLName(),
                t.getDept(),
                t.getTeacherId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteTeacher(int id) {
        //YOUR CODE STARTS HERE


        //YOUR CODE ENDS HERE
    }
}
