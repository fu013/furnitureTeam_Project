package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.dto.UserRegisterDto;
import our.example.furniture.repository.MyPageMapper;
import our.example.furniture.repository.PostMapper;
import our.example.furniture.repository.UserRegisterMapper;
import our.example.furniture.service.PostService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyPageController {
    @Autowired
    private UserRegisterMapper userRegisterMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;
    @Autowired
    private MyPageMapper myPageMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // myPage_CurrentView(최근 본 페이지) url 요청 처리
    @GetMapping("myPage_CurrentView")
    public String myPage_CurrentView(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpServletRequest request, HttpSession session, Model model) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            List<PostDTO> viewPostList = postService.getViewPostList(params, response, request);
            model.addAttribute("viewPostList", viewPostList);
        }
        return "myPage_CurrentView";
    }
    
    // myPage_Dibs(찜 목록) 요청 처리
    @GetMapping("myPage_Dibs")
    public String myPage_Dibs(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            List<PostDTO> selectDibsPostList = postService.getDibsPostList(params, session);
            model.addAttribute("selectDibsPostList", selectDibsPostList);
        }
        return "myPage_Dibs";
    }
    // myPage_Like(좋아요한 페이지) url 요청 처리
    @GetMapping("myPage_Like")
    public String like(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            List<PostDTO> selectLikePostList = postService.getLikePostList(params, session);
            model.addAttribute("selectLikePostList", selectLikePostList);
        }
        return "myPage_Like";
    }

    // myPage_UploadPost(업로드한 게시물) url 요청 처리
    @GetMapping("myPage_UploadPost")
    public String myPage_UploadPost(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        } else {
            List<PostDTO> selectUploadPostList = postService.getUploadPostList(params, session);
            model.addAttribute("selectUploadPostList", selectUploadPostList);
        }
        return "myPage_UploadPost";
    }
    // myPage_UserInfoFix(회원정보수정) url 요청 처리
    @GetMapping("myPage_UserInfoFix")
    public String myPage_UserInfoFix(UserRegisterDto userRegisterDto, HttpSession session, HttpServletResponse response, Model model) throws IOException {
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
            UserRegisterDto userInfo = userRegisterMapper.selectUserTable(userRegisterDto);
            model.addAttribute("userInfo", userInfo);
        }
        return "myPage_UserInfoFix";
    }
    // myPage_UserWithdrawal(회원탈퇴) url 요청 처리
    @GetMapping("myPage_UserWithdrawal")
    public String myPage_UserWithdrawal(HttpSession session, HttpServletResponse response) throws IOException {
        if(session.getAttribute("loginUser") == null) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요한 서비스입니다.');");
            out.println("location.href='/';");
            out.println("</script>");
            out.close();
        }
        return "myPage_UserWithdrawal";
    }

    // 찜 목록 버튼 클릭시, 아이콘 색깔에 따른 요청 처리
    @ResponseBody
    @PostMapping("/dibsSuccess")
    public String dibsSuccess(PostDTO params, HttpSession session) {
        String result = "";
        if(session.getAttribute("loginUser") == null) {
            result = "로그인이 필요한 서비스입니다.";
        } else {
            params.setUserLoginId(session.getAttribute("loginUser").toString());
            int checkDibs = myPageMapper.CheckDibs(params);
            if(checkDibs == 0) {
                myPageMapper.InsertDibs(params);
                result = "찜 목록에 추가되었습니다.";
            } else {
                result = "이미 찜 목록에 등록되있습니다.";
            }
        }
        return result;
    }

    // 좋아요 버튼 클릭시, 아이콘 색깔에 따른 요청 처리
    @ResponseBody
    @PostMapping("/like")
    public String Like(PostDTO params, HttpSession session, Model model) {
        String result = "";
        if(session.getAttribute("loginUser") == null) {
            result = "로그인이 필요한 서비스입니다.";
        } else {
            params.setUserLoginId(session.getAttribute("loginUser").toString());
            int checkLike = myPageMapper.CheckLike(params);
            if(checkLike == 0) {
                myPageMapper.InsertLike(params);
                myPageMapper.UpdateLike(params);
                result = "좋아요가 등록되었습니다.";
            } else {
                result = "이미 좋아요에 등록되있습니다.";
            }
        }
        return result;
    }

    // 찜 게시물 삭제 [체크박스]
    @ResponseBody
    @PostMapping("/dibsPostDelete")
    public String dibsPostDelete(int deletePostNum, HttpSession session, PostDTO postDTO) {
        if(session.getAttribute("loginUser") != null) {
            List<Integer> deletePostNumList = new ArrayList<Integer>();
            postDTO.setUserLoginId(session.getAttribute("loginUser").toString());
            deletePostNumList.add(deletePostNum);
            for (int i = 0; i < deletePostNumList.size(); i++) {
                postDTO.setProduct_no(deletePostNumList.get(i));
                log.info(deletePostNumList.get(i));
                myPageMapper.DeleteDibs(postDTO);
            }
        }
        return null;
    }

    // 업로드 게시물 삭제 [체크박스]
    @ResponseBody
    @PostMapping("/uploadPostDelete")
    public String uploadPostDelete(int deletePostNum, HttpSession session, HttpServletRequest request, HttpServletResponse response, PostDTO postDTO) {
        if(session.getAttribute("loginUser") != null) {
            List<Integer> deletePostNumList = new ArrayList<Integer>();
            List<String> deletePostNameList = new ArrayList<String>();
            deletePostNumList.add(deletePostNum);
            deletePostNameList.add(postDTO.getProductName());
            postDTO.setUserLoginId(session.getAttribute("loginUser").toString());
            for (int i = 0; i < deletePostNumList.size(); i++) {
                String cookieName = "ViewPostName" + deletePostNumList.get(i).toString();
                Cookie cookie = new Cookie(cookieName, deletePostNameList.get(i));
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                postDTO.setProduct_no(deletePostNumList.get(i));
                myPageMapper.DeleteUploadPost(postDTO);
            }
        }
        return null;
    }
    @ResponseBody
    @PostMapping("/uploadPostFixed")
    public String uploadPostFixed(HttpSession session, PostDTO params) {
        String result = "";
        if(session.getAttribute("loginUser") != null) {
            params.setUserLoginId(session.getAttribute("loginUser").toString());
            myPageMapper.UpdatePost(params);
            result = "게시물이 성공적으로 수정되었습니다.";
        } else {
            result = "게시물 수정이 실패했습니다.";
        }
        return result;
    }
}