package hansung.information.controller;

import hansung.information.model.Register;
import hansung.information.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    // 수강 신청 조회
    @GetMapping("/information")
    public String showInformation(Model model) {
        List<Register> register = registerService.getAllRegisters();
        model.addAttribute("id_registers", register);

        return "information";
    }

    // 수강 신청
    @GetMapping("/selectclass")
    public String selectClass(Model model) {

        model.addAttribute("select", new Register());

        return "selectclass";
    }

    // 데이터 유효성 검사
    @PostMapping("/doselect")
    public String doSelect(Model model, @Valid Register register, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("잘못 입력하셨습니다");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "selectclass";
        }

        // 수강 신청 완료
        registerService.insert(register);

        return "selectdone";
    }

}
