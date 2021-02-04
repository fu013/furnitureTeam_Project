package our.example.furniture.controller;
import org.apache.catalina.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.UserRegisterMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserRegisterController {
    @Autowired
    private UserRegisterMapper userRegisterMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // 등록 성공시 Data Insert
    @PostMapping("/userRegisterSuccess")
    public String temp2(UserRegisterDto userRegisterDto) {
        userRegisterMapper.insertUserRegister(userRegisterDto);
        return "index";
    }

    // 회원가입 ID 중복 체크
    @ResponseBody
    @PostMapping("/idOverlapCheck")
    public String idOverlapCheck(UserRegisterDto userRegisterDto) {
        String result = userRegisterMapper.idOverlap(userRegisterDto);
        if(result == null) {
            result = "이 아이디는 사용가능합니다.";
        } else {
            result = "이 아이디는 이미 사용중입니다.";
        }
        return result;
    }
    // 회원가입 Email 중복 체크
    @ResponseBody
    @PostMapping("/emailOverlapCheck")
    public String emailOverlapCheck(UserRegisterDto userRegisterDto) {
        String result = userRegisterMapper.emailOverlap(userRegisterDto);
        if(result == null) {
            result = "이 이메일은 사용가능합니다.";
        } else {
            result = "이 이메일은 이미 사용중입니다.";
        }
        return result;
    }
    // 기존 비밀번호가 일치하는지 체크
    @ResponseBody
    @PostMapping("/passwordCheck")
    public String passwordCheck(UserRegisterDto userRegisterDto, HttpSession session) {
        userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
        String result = userRegisterMapper.passwordCheck(userRegisterDto);
        if(result == null) {
            result =  "패스워드가 일치하지 않습니다.";
        } else {
            result = "패스워드가 일치합니다.";
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/userInfoChange")
    public String userInfoChange(UserRegisterDto userRegisterDto, HttpSession session) {
        userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
        userRegisterMapper.userInfoChange(userRegisterDto);
        return "회원정보가 수정되었습니다(자동 재로그인).";
    }
    @ResponseBody
    @PostMapping("/userWithdrawal")
    public String userWithdrawal(UserRegisterDto userRegisterDto) {
        userRegisterMapper.userInfoDelete(userRegisterDto);
        return "회원탈퇴가 완료되었습니다.";
    }
}
