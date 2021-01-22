package our.example.furniture.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.UserRegisterMapper;

@Controller
public class UserRegisterController {
    @Autowired
    private UserRegisterMapper userRegisterMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // 등록 성공시 Data Insert
    @PostMapping("/userRegisterSuccess")
    public String temp2(UserRegisterDto userRegisterDto) {
        userRegisterMapper.insertRegister(userRegisterDto);
        return "index";
    }
    // 로그인 중복 체크
    @ResponseBody
    @PostMapping("/idOverlapCheck")
    public String idOverlapCheck(UserRegisterDto userRegisterDto, HttpServletRequest request, Model model) {
        String result = userRegisterMapper.idOverlap(userRegisterDto);
        if(result == null) {
            result = "이 아이디는 사용가능합니다.";
        } else {
            result = "이 아이디는 이미 사용중입니다.";
        }
        return result;
    }
}