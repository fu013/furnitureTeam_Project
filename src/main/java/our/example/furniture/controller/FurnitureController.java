package our.example.furniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import our.example.furniture.dto.PostWriterDto;
import our.example.furniture.dto.RegisterDto;

@Controller
public class FurnitureController {
    // index[홈페이지] :: URL 매핑
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    // postWriter[글쓰기] :: URL 매핑
    @GetMapping("/postWriter")
    public String postWriter(Model model) {
        return "postWriter";
    }

	 // register[회원가입] :: URL 매핑
	 @GetMapping("/register")
	 public String register(RegisterDto registerDto) {
	 System.out.println(registerDto.getRegisterPhone());
	 return "register";
	 }
	 
    // postWriter[게시글작성] :: URL 매핑
    @PostMapping("/productRegister")
    public String temp(PostWriterDto postWriterDto) {
        System.out.println(postWriterDto.getProductName());
        return "index";
    }
}
