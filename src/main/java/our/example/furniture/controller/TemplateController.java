package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.repository.PostMapper;
import our.example.furniture.service.PostService;

import java.io.IOException;
import java.util.List;

@Controller
public class TemplateController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostMapper postMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // shop url 요청시 template/index.html 로 DOM 랜더링 및 전체 게시물 조회 리스트 뿌리기
    @GetMapping("/shop")
    public String openPostList(@ModelAttribute("params") PostDTO params, Model model) throws IOException {
        // 최신순, 가격순, 추천순, 조회순에 대한 파라미터를 받아서, 페이지네이션에도 searchType 을 정해주어 페이지 이동(페이징)을 해도 필터링이 풀리지않고 적용되도록한다.
        if (params.getSearchType() == null) {
            params.setSearchType("product_no");
        }
        params.setRecordsPerPage(6);
        List<PostDTO> postList = postService.getPostList(params);

        model.addAttribute("postList", postList);
        for(int i = 0; i < postList.size(); i++) {
            if(postList.get(i).getImg_url_main() == null) {
                String a = "img/null.gif";
                postList.get(i).setImg_url_main(a);
            }
        }
        return "shop";
    }

    // "/" url 요청시, template/index.html 로 DOM 랜더링
    @RequestMapping("/")
    public String index(PostDTO params, Model model) {
        List<PostDTO> indexPostList = postMapper.indexPostList(params);
        for(int i = 0; i < indexPostList.size(); i++) {
            if(indexPostList.get(i).getImg_url_main() == null) {
                String a = "img/null.gif";
                indexPostList.get(i).setImg_url_main(a);
            }
        }
        model.addAttribute("indexPostList", indexPostList);
        return "index";
    }

    // login url 요청시, template/login.html 로 DOM 랜더링
    @GetMapping("/login")
    public String login(Model model) { return "login"; }

    // postWriter url 요청시, template/postWriter.html 로 DOM 랜더링
    @GetMapping("/postWriter")
    public String postWriter(Model model) { return "postWriter"; }

    // userRegister url 요청시, template/userRegister.html 로 DOM 랜더링
    @GetMapping("/userRegister")
    public String register(Model model) {
        return "userRegister";
    }
    
    // findUserId url 요청시, template/findUserId.html 로 DOM 랜더링
    @GetMapping("/findUserId")
    public String findUserId(Model model) { return "findUserId"; }

    // findUserPassword url 요청시, template/findUserPassword.html 로 DOM 랜더링
    @GetMapping("/findUserPassword")
    public String findUserPassword(Model model) { return "findUserPassword"; }

    // modifyUserPassword url 요청시, template/modifyUserPassword.html 로 DOM 랜더링
    @GetMapping("/modifyUserPassword")
    public String modifyUserPassword(Model model) { return "modifyUserPassword"; }
}
