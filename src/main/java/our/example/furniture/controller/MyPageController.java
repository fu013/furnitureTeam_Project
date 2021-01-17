package our.example.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyPageController {

    // CurrentView URL 매핑
    @GetMapping("myPage_CurrentView")
    public String CurrentView(Model model) { return "myPage_CurrentView"; }
}