package hansung.information.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger("hansung.information.controller.HomeController");

    @GetMapping("/")
    public String Home(HttpServletRequest request) {
        return "home";
    }
}


