package ca.sheridancollege.sin12743.springweb.Repository;

import ca.sheridancollege.sin12743.springweb.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class StudentRepo {
    protected NamedParameterJdbcTemplate jdbc;
    @Autowired
    public StudentRepo(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public ArrayList<Student> getStudents() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM Student";
        ArrayList<Student> students = (ArrayList<Student>)
                jdbc.query(query, parameters, new BeanPropertyRowMapper<Student>(Student.class));

        return students;

    }   public Student getStudentById(int id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM STUDENT WHERE id=:id";
        parameters.addValue("id", id);
        ArrayList<Student> students =
                (ArrayList<Student>)jdbc.query(query, parameters,
                        new BeanPropertyRowMapper<Student>(Student.class));
        if (students.size()>0)
            return students.get(0);
        return null;
    }


    public void addStudent(Student student) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "INSERT INTO STUDENT (name) " +
                "VALUES (:name)";
        parameters.addValue("name", student.getName());


        jdbc.update(query, parameters);
    }
    public void updateStudent(Student student) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "UPDATE STUDENT SET name=:name WHERE id=:id";
        parameters.addValue("name", student.getName());

        parameters.addValue("id", student.getId());
        jdbc.update(query, parameters);
    }
    }


