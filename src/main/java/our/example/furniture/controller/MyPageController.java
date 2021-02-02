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
import our.example.furniture.repository.MyPageMapper;
import our.example.furniture.repository.PostMapper;
import our.example.furniture.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MyPageController {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;
    @Autowired
    private MyPageMapper myPageMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // CurrentView URL 매핑
    @GetMapping("myPage_CurrentView")
    public String CurrentView(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpServletRequest request, Model model) {
        List<PostDTO> viewPostList = postService.getViewPostList(params, response, request);
        model.addAttribute("viewPostList", viewPostList);
        return "myPage_CurrentView";
    }
    
    // Dibs URL 매핑
    @GetMapping("myPage_Dibs")
    public String dibs(@ModelAttribute("params") PostDTO params, HttpSession session, Model model) {
        List<PostDTO> selectDibsPostList = postService.getDibsPostList(params, session);
        model.addAttribute("selectDibsPostList", selectDibsPostList);
        return "myPage_Dibs";
    }
    // 좋아요 매핑
    @GetMapping("myPage_Like")
    public String like(@ModelAttribute("params") PostDTO params, HttpSession session, Model model) {
        List<PostDTO> selectLikePostList = postService.getLikePostList(params, session);
        model.addAttribute("selectLikePostList", selectLikePostList);
        return "myPage_Like";
    }

    // 찜목록 요청값 DB에 저장
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
                myPageMapper.DeleteDibs(params);
                result = "찜 목록에서 삭제되었습니다.";
            }
        }
        return result;
    }
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
                myPageMapper.DeleteLike(params);
                myPageMapper.UpdateLike(params);
                result = "좋아요에서 삭제되었습니다.";
            }
        }
        return result;
    }
}