package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.LoginMapper;

@Controller
public class LoginController {
	@Autowired
    private LoginMapper loginMapper;
	private Log log = LogFactory.getLog(this.getClass());

// login[로그인] :: URL 매핑
    @GetMapping("/login")
    public String login(Model model) {
    	return "login";
    }
    
    @ResponseBody
    @PostMapping("/loginSuccess")
    public String temp(UserRegisterDto loginDto) {
    	String data = loginMapper.overlapLogin(loginDto);
    	log.info(loginDto.getuserRegisterId());
    	return data;
    }
}
