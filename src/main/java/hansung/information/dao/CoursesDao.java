package hansung.information.dao;

import hansung.information.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoursesDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public List<Courses> getCourses() {
        String sqlStatement = "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Courses>() {
            @Override
            public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
                Courses courses = new Courses();
                courses.setId(rs.getInt("id"));
                courses.setYear(rs.getString("year"));
                courses.setSemester(rs.getInt("semester"));
                courses.setClass_code(rs.getString("class_code"));
                courses.setClass_name(rs.getString("class_name"));
                courses.setClass_type(rs.getString("class_type"));
                courses.setProfessor(rs.getString("professor"));
                courses.setPoint(rs.getInt("point"));
                return courses;
            }
        });
    }

    // 해당 년도, 학기 수강신청 목록
    public List<Courses> getCoursesByYearAndSemester(String year, int semester) {
        String sqlStatement = "select * from courses where year=? and semester=?";
        return jdbcTemplate.query(sqlStatement, new Object[]{year, semester},
                new RowMapper<Courses>() {
                    @Override
                    public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Courses courses = new Courses();
                        courses.setId(rs.getInt("id"));
                        courses.setYear(rs.getString("year"));
                        courses.setSemester(rs.getInt("semester"));
                        courses.setClass_code(rs.getString("class_code"));
                        courses.setClass_name(rs.getString("class_name"));
                        courses.setClass_type(rs.getString("class_type"));
                        courses.setProfessor(rs.getString("professor"));
                        courses.setPoint(rs.getInt("point"));
                        return courses;
                    }
                });
    }
}
