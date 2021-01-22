package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.repository.PostMapper;
import our.example.furniture.service.PostService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class MyPageController {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;
    private Log log = LogFactory.getLog(this.getClass());

    // CurrentView URL 매핑
    @GetMapping("myPage_CurrentView")
    public String CurrentView(@ModelAttribute("params") PostDTO params, HttpServletResponse response, HttpServletRequest request, Model model) {
        List<PostDTO> viewPostList = postService.getViewPostList(params, response, request);
        model.addAttribute("viewPostList", viewPostList);
        return "myPage_CurrentView";
    }
}