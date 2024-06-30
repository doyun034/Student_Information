package hansung.information.controller;

import hansung.information.model.Courses;
import hansung.information.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/allinformation")
    public String showAllInformation(Model model) {
        Map<String, Integer> YearAndSemester = coursesService.getYearAndSemester();
        model.addAttribute("id_YearAndSemester", YearAndSemester);
        return "allinformation";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("year") String year,
                             @RequestParam("semester") int semester,
                             Model model) {
        List<Courses> courses = coursesService.getCoursesByYearAndSemester(year, semester);
        model.addAttribute("id_courses", courses);
        return "detail";
    }
}
