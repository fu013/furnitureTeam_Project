package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import our.example.furniture.dto.*;
import our.example.furniture.repository.*;
import java.util.List;

@Controller
public class TemplateController {
    @Autowired
    private PostMapper postMapper;

    private Log log = LogFactory.getLog(this.getClass());

    // index[홈페이지] :: URL 매핑
    @GetMapping("/")
    public String index(Model model) {
        List<SelectedPostDto> postList = postMapper.SelectAllProduct();
        model.addAttribute("postList", postList);
        for(int i = 0; i < postList.size(); i++) {
            if(postList.get(i).getImg_url_main() == null) {
                String a = "img/null.gif";
                postList.get(i).setImg_url_main(a);
            }
        }
        return "index";
    }
    // postWriter[글쓰기] :: Template Mapping
    @GetMapping("/postWriter")
    public String postWriter(Model model) { return "postWriter"; }

    // register[회원가입] :: URL 매핑
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
}
