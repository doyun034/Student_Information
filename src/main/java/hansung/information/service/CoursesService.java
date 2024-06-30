package hansung.information.service;

import hansung.information.dao.CoursesDao;
import hansung.information.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    private CoursesDao coursesDao;

    public Map<String, Integer> getYearAndSemester() {
        List<Courses> courses = coursesDao.getCourses();
        return courses.stream()
                .collect(Collectors.toMap(
                        course -> course.getYear() + "-" + course.getSemester(),
                        Courses::getPoint,
                        Integer::sum
                ));
    }

    public List<Courses> getCoursesByYearAndSemester(String year, int semester) {
        return coursesDao.getCoursesByYearAndSemester(year, semester);
    }
}
