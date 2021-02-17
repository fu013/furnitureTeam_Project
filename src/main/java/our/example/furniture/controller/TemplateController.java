package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.javassist.compiler.ast.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import our.example.furniture.dto.*;
import our.example.furniture.repository.*;
import our.example.furniture.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TemplateController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostMapper postMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // index url 요청시 template/index.html 로 DOM 랜더링 및 전체 게시물 조회 리스트 뿌리기
    @RequestMapping("/")
    public String openPostList(@ModelAttribute("params") PostDTO params, Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 최신순, 가격순, 추천순, 조회순에 대한 파라미터를 받아서, 페이지네이션에도 searchType 을 정해주어 페이지 이동(페이징)을 해도 필터링이 풀리지않고 적용되도록한다.
        if (params.getSearchType() == null) {
            params.setSearchType("product_no");
        }
        List<PostDTO> postList = postService.getPostList(params);

        model.addAttribute("postList", postList);
        for(int i = 0; i < postList.size(); i++) {
            if(postList.get(i).getImg_url_main() == null) {
                String a = "img/null.gif";
                postList.get(i).setImg_url_main(a);
            }
        }
        return "index";
    }
    // login url 요청시, template/login.html 로 DOM 랜더링
    @GetMapping("/login")
    public String login(Model model) { return "login"; }

    // postWriter url 요청시, template/login.html 로 DOM 랜더링
    @GetMapping("/postWriter")
    public String postWriter(Model model) { return "postWriter"; }

    // userRegister url 요청시, template/login.html 로 DOM 랜더링
    @GetMapping("/userRegister")
    public String register(Model model) {
        return "userRegister";
    }
}
