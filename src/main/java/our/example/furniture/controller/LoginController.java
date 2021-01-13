package our.example.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.LoginMapper;

@Controller
public class LoginController {
	@Autowired
    private LoginMapper loginMapper;

// login[로그인] :: URL 매핑
    @GetMapping("/login")
    public String login(Model model) {
    	return "login";
    }
    
    @PostMapping("/loginSuccess")
    public String temp(UserRegisterDto loginDto) {
    	loginMapper.overlapLogin(loginDto);
    	loginMapper.overlapPassword(loginDto);
    	return "index";
    }
}
