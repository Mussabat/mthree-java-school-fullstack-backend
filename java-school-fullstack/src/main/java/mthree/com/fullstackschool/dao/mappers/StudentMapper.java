package mthree.com.fullstackschool.dao.mappers;

import mthree.com.fullstackschool.model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE
        // Create an empty Student to fill in from the current row of the result set.
        Student student = new Student();

        // sid, fName and lName are the column names in the student table;
        // they differ from the Student field names.
        student.setStudentId(rs.getInt("sid"));
        student.setStudentFirstName(rs.getString("fName"));
        student.setStudentLastName(rs.getString("lName"));

        // Spring calls mapRow once per row
        return student;

        //YOUR CODE ENDS HERE
    }
}
