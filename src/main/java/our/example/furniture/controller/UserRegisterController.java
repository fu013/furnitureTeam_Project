package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import our.example.furniture.dto.UserRegisterDTO;
import our.example.furniture.repository.UserRegisterMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserRegisterController {
    @Autowired
    private UserRegisterMapper userRegisterMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // 등록 성공시 Data Insert
    @PostMapping("/userRegisterSuccess")
    public String temp2(UserRegisterDTO userRegisterDto) {
        userRegisterMapper.insertUserRegister(userRegisterDto);
        return "index";
    }

    // 회원가입 ID 중복 체크
    @ResponseBody
    @PostMapping("/idOverlapCheck")
    public String idOverlapCheck(UserRegisterDTO userRegisterDto) {
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
    public String emailOverlapCheck(UserRegisterDTO userRegisterDto) {
        String result = userRegisterMapper.emailOverlap(userRegisterDto);
        if(result == null) {
            result = "이 이메일은 사용가능합니다.";
        } else {
            result = "이 이메일은 이미 사용중입니다.";
        }
        return result;
    }
    // 기존 비밀번호가 맞는지 체크(인증 절차)
    @ResponseBody
    @PostMapping("/passwordCheck")
    public String passwordCheck(UserRegisterDTO userRegisterDto, HttpSession session) {
        userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
        String result = userRegisterMapper.passwordCheck(userRegisterDto);
        if(result == null) {
            result =  "패스워드가 일치하지 않습니다.";
        } else {
            result = "패스워드가 일치합니다.";
        }
        return result;
    }
    // 회원정보 수정 요청에 대한 응답
    @ResponseBody
    @PostMapping("/userInfoChange")
    public String userInfoChange(UserRegisterDTO userRegisterDto, HttpSession session) {
        userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
        userRegisterMapper.userInfoChange(userRegisterDto);
        return "회원정보가 수정되었습니다(자동 재로그인).";
    }
    // 회원정보 탈퇴 요청에 대한 응답
    @ResponseBody
    @PostMapping("/userWithdrawal")
    public String userWithdrawal(UserRegisterDTO userRegisterDto, HttpServletRequest request) {
        userRegisterMapper.userInfoDelete(userRegisterDto);

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies) {
            if(cookie.getName().contains("ViewPostName")) {
                cookie.setMaxAge(0);
            }
        }
        return "회원탈퇴가 완료되었습니다.";
    }
    // 회원 정보 수정 - 보안 :: 기존 비밀번호 입력 페이지
    @GetMapping("/myPage_passwordCheck")
    public String myPage_passwordCheck(Model model, UserRegisterDTO userRegisterDto, HttpServletResponse response, HttpSession session) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
            UserRegisterDTO userInfo = userRegisterMapper.selectUserTable(userRegisterDto);
            model.addAttribute("userInfo", userInfo);
        }
        return "myPage_passwordCheck";
    }
    // 회원 탈퇴 - 보안 :: 기존 비밀번호 입력 페이지
    @GetMapping("/myPage_passwordCheck2")
    public String myPage_passwordCheck2(Model model, UserRegisterDTO userRegisterDto, HttpServletResponse response, HttpSession session) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            userRegisterDto.setLoginId(session.getAttribute("loginUser").toString());
            UserRegisterDTO userInfo = userRegisterMapper.selectUserTable(userRegisterDto);
            model.addAttribute("userInfo", userInfo);
        }
        return "myPage_passwordCheck2";
    }
}
