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

    // login[로그인] :: URL 매핑
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    // 로그인 요청
    @ResponseBody
    @PostMapping("/loginSuccess")
    public String loginSuccess(UserRegisterDto userRegisterDto, HttpServletRequest request, Model model) {
        String result = loginMapper.overlapLogin(userRegisterDto);
        if (result != null) { // 로그인 성공
            String userName = userRegisterDto.getLoginId();
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", userName);
            session.setMaxInactiveInterval(60*60);
        /*
            String name = (String) session.getAttribute("loginUser");
            log.info("세션에 로그인 되었습니다.");
            log.info("세션정보 확인 = " + name);
        */
        } else { // 로그인 실패
            log.info("아이디나 비밀번호가 맞지않아 응답값이 Null 입니다.");
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
        out.println("location.href=document.referrer;");
        out.println("</script>");
        out.close();
    }
}