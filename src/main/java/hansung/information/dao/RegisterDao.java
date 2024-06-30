package hansung.information.dao;

import hansung.information.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegisterDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from register";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public Register getRegister(String year) {
        String sqlStatement= "select * from register where year=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {year},
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register = new Register();
                        register.setId(rs.getInt("id"));
                        register.setYear(rs.getString("year"));
                        register.setSemester(rs.getInt("semester"));
                        register.setClass_code(rs.getString("class_code"));
                        register.setClass_name(rs.getString("class_name"));
                        register.setClass_type(rs.getString("class_type"));
                        register.setProfessor(rs.getString("professor"));
                        register.setPoint(rs.getInt("point"));

                        return register;
                    }
                });
    }

    public List<Register> getRegisters() {
        String sqlStatement= "select * from register";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Register>() {
            @Override
            public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                Register register = new Register();
                register.setYear(rs.getString("year"));
                register.setSemester(rs.getInt("semester"));
                register.setClass_code(rs.getString("class_code"));
                register.setClass_name(rs.getString("class_name"));
                register.setClass_type(rs.getString("class_type"));
                register.setProfessor(rs.getString("professor"));
                register.setPoint(rs.getInt("point"));
                return register;
            }
        });
    }

    public boolean insert(Register register) {

        String year = register.getYear();
        Integer semester = register.getSemester();
        String class_code = register.getClass_code();
        String class_name = register.getClass_name();
        String class_type = register.getClass_type();
        String professor = register.getProfessor();
        Integer point = register.getPoint();

        String sqlStatement= "insert into register (year, semester, class_code, class_name, class_type, professor, point) values (?, ?, ?, ?, ?, ?, ?)";
        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, class_code, class_name, class_type, professor, point}) == 1);
    }

    public boolean update(Register register) {
        Integer id = register.getId();
        String year = register.getYear();
        Integer semester = register.getSemester();
        String class_code = register.getClass_code();
        String class_name = register.getClass_name();
        String class_type = register.getClass_type();
        String professor = register.getProfessor();
        Integer point = register.getPoint();
        String sqlStatement= "update register set year=?, semester=?, class_code=?, class_name=?, class_type=?, professor=?, point=? where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, class_code, class_name, class_type, professor, point}) == 1);
    }

    public boolean delete(int id) {
        String sqlStatement= "delete from register where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }
}
