package our.example.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.UserRegisterMapper;

@Controller
public class UserRegisterController {
	@Autowired
    private UserRegisterMapper userRegisterMapper;

// register[회원가입] :: URL 매핑
    @GetMapping("/userRegister")
    public String userRegister(Model model) {
        return "userRegister";
    }

// 등록 성공시 Data Insert
    @PostMapping("/userRegisterSuccess")
    public String temp2(UserRegisterDto userRegisterDto) {
        userRegisterMapper.insertUserRegister(userRegisterDto);
        return "index";
    }
}
