package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import our.example.furniture.dto.*;
import our.example.furniture.repository.*;
import our.example.furniture.service.UploadInnerImages;
import our.example.furniture.service.UploadMainImage;

import java.util.List;

@Controller
public class FurnitureController {
    @Autowired
    private UploadInnerImages uploadInnerImages;
    @Autowired
    private UploadMainImage uploadMainImage;
    @Autowired
    private InnerImagesUploadMapper innerImagesUploadMapper;
    @Autowired
    private MainImageUploadMapper mainImageUploadMapper;
    @Autowired
    private PostWriterMapper postWriterMapper;
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private SelectAllProductMapper selectAllProductMapper;

    private Log log = LogFactory.getLog(this.getClass());

    // index[홈페이지] :: URL 매핑
    @GetMapping("/")
    public String index(Model model) {
        List<SelectedPostDto> postList = selectAllProductMapper.SelectAllProduct();
        model.addAttribute("postList", postList);
        return "index";
    }
    // postWriter[글쓰기] :: URL 매핑

    @GetMapping("/postWriter")
    public String postWriter(Model model) {
        return "postWriter";
    }

    // register[회원가입] :: URL 매핑
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/registerSuccess")
    public String temp2(RegisterDto registerDto) {
        registerMapper.insertRegister(registerDto);
        return "index";
    }

    // postWriter[게시글작성] :: URL 매핑
    @PostMapping("/productRegister")
    public String temp(PostWriterDto postWriterDto) throws Exception {
        postWriterMapper.insertProductInfo(postWriterDto);

        // 메인 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(!postWriterDto.getProductMainImg().isEmpty()) {
            List<MainImageInfoDto> MainImageLogic = uploadMainImage.MainImageLogic(postWriterDto);
            mainImageUploadMapper.InsertMainImage(MainImageLogic);
        }

        // 내부 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(postWriterDto.getProductImg().length >= 1 && !postWriterDto.getProductImg()[0].isEmpty()) {
            List<InnerImagesInfoDto> InnerImageLogic = uploadInnerImages.InnerImagesLogic(postWriterDto);
            innerImagesUploadMapper.InsertInnerImages(InnerImageLogic);
        }
        return "index";
    }
}
