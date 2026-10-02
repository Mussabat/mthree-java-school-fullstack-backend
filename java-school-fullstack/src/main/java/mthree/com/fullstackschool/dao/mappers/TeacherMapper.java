package mthree.com.fullstackschool.dao.mappers;

import mthree.com.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        // Create an empty Teacher to fill in from the current row of the result set.
        Teacher teacher = new Teacher();

        // tid, tFName and tLName are the column names in the teacher table;
        // they differ from the Teacher field names.
        teacher.setTeacherId(rs.getInt("tid"));
        teacher.setTeacherFName(rs.getString("tFName"));
        teacher.setTeacherLName(rs.getString("tLName"));
        teacher.setDept(rs.getString("dept"));

        // Spring calls mapRow once per row 
        return teacher;

        //YOUR CODE ENDS HERE
    }
}
