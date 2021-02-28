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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // 로그인 요청
    @ResponseBody
    @PostMapping("/loginSuccess")
    public String loginSuccess(UserRegisterDto userRegisterDto, HttpServletRequest request, Model model) {
        String result = loginMapper.overlapLogin(userRegisterDto);
        // 로그인 성공
        if (result != null) {
            String userName = userRegisterDto.getUserRegisterId();
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", userName);
            session.setMaxInactiveInterval(60*60);
            result = "로그인에 성공했습니다.";
        } else { // 로그인 실패
            result = "아이디나 비밀번호가 일치하지 않습니다.";
        }
        return result;
    }

    // 로그아웃 요청
    @GetMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('로그아웃되었습니다.');");
        out.println("location.href='/';");
        out.println("</script>");
        out.close();
    }

    // 아이디 찾기
    @ResponseBody
    @PostMapping("/findUserId")
    public String findUserId(UserRegisterDto userRegisterDto) {
        String result = loginMapper.findId(userRegisterDto);
        if(result == null) {
            result = "일치하는 정보가 없습니다.";
        } else {
            result = "회원님의 아이디는 " + loginMapper.findId(userRegisterDto) + " 입니다.";
        }
        return result;
    }

    // 비밀번호 찾기
    @ResponseBody
    @PostMapping("/findUserPassword")
    public String findUserPassword(UserRegisterDto userRegisterDto, HttpSession session) {
        String result = loginMapper.findPassword(userRegisterDto);
        if(result == null) {
            result = "일치하는 정보가 없습니다.";
        } else {
            /*result = "회원님의 비밀번호는 " + loginMapper.findPassword(userRegisterDto) + " 입니다.";*/
            session.setAttribute("tempUserId", userRegisterDto.getUserRegisterId());
            session.setMaxInactiveInterval(60*60);
            result = "회원님의 정보가 일치합니다.";
        }
        return result;
    }

    // 비밀번호 수정
    @ResponseBody
    @PostMapping("/modifyUserPassword")
    public String modifyPassword(UserRegisterDto userRegisterDto, HttpSession session) {
        userRegisterDto.setUserRegisterId(session.getAttribute("tempUserId").toString());
        String result = loginMapper.modifyPassword(userRegisterDto);
        result = "회원님의 비밀번호가 변경되었습니다.";
        session.invalidate();
        return result;
    }
}