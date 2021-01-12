package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import our.example.furniture.dto.*;
import our.example.furniture.repository.*;
import our.example.furniture.service.UploadInnerImages;
import our.example.furniture.service.UploadMainImage;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private UploadInnerImages uploadInnerImages;
    private UploadMainImage uploadMainImage;
    private PostMapper postMapper;
    private Log log = LogFactory.getLog(this.getClass());

    // 상품 게시글 작성
    @PostMapping("/productRegister")
    public String temp(PostWriterDto postWriterDto) throws Exception {
        postMapper.insertProductInfo(postWriterDto);

        // 메인 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(!postWriterDto.getProductMainImg().isEmpty()) {
            List<MainImageInfoDto> MainImageLogic = uploadMainImage.MainImageLogic(postWriterDto);
            postMapper.InsertMainImage(MainImageLogic);
        }

        // 내부 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(postWriterDto.getProductImg().length >= 1 && !postWriterDto.getProductImg()[0].isEmpty()) {
            List<InnerImagesInfoDto> InnerImageLogic = uploadInnerImages.InnerImagesLogic(postWriterDto);
            postMapper.InsertInnerImages(InnerImageLogic);
        }
        return "index";
    }

    // 상품 상세페이지
    @GetMapping("/postInfo")
    public String postInfo(@RequestParam("post_no") int post_no, SelectedPostDto selectedPostDto, Model model) {
        selectedPostDto.setProduct_No(post_no);
        SelectedPostDto postInfo = postMapper.SelectPost(selectedPostDto);
        List<SelectedPostDto> postImages = postMapper.SelectPostImages(selectedPostDto);
        if(postInfo.getImg_url_main() == null) {
            String a = "img/null.gif";
            postInfo.setImg_url_main(a);
        }
        model.addAttribute("postInfo", postInfo);
        model.addAttribute("postImages", postImages);
        return "postInfo";
    }
}
