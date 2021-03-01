package our.example.furniture.filter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/*")
public class LoginFilter implements Filter {
    private Log log = LogFactory.getLog(this.getClass());
    public void init(FilterConfig fc) throws ServletException { } // 필터 초기화 작업
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest h_request = (HttpServletRequest)request;
        String currentUrl = h_request.getRequestURI();
        /* 특정 url 접근시 로그인 필터 실행*/
        if (h_request.getSession().getAttribute("loginUser") == null && currentUrl.contains("myPage") || h_request.getSession().getAttribute("loginUser") == null && currentUrl.contains("postWriter")) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        }
        chain.doFilter(request, response);
    }
    public void destroy() { }
}
