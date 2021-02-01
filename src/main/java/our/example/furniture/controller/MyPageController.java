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
    public String dibs(Model model) {
        return "myPage_Dibs";
    }

    // 찜목록 요청값
    @ResponseBody
    @PostMapping("/dibsSuccess")
    public String dibsSuccess(PostDTO params, HttpSession session) {
        int checkDibs = myPageMapper.CheckDibs(params);
        String result = "";
        if(session.getAttribute("loginUser") == null) {
            result = "로그인이 필요한 서비스입니다.";
        } else {
            if(checkDibs == 0) {
                String userLoginId = session.getAttribute("loginUser").toString();
                result = "찜 목록에 추가되었습니다.";
                params.setUserLoginId(userLoginId);
                myPageMapper.InsertDibs(params);
            } else {
                result = "이미 찜목록에 추가된 상품입니다.";
            }
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/like")
    public String Like(PostDTO postDTO, Model model) {
        return null;
    }
    @ResponseBody
    @PostMapping("/likeDelete")
    public String LikeDelete(PostDTO postDTO, Model model) {
        return null;
    }
}