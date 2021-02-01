package our.example.furniture.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import our.example.furniture.dto.*;
import our.example.furniture.repository.*;
import our.example.furniture.service.PostReviewService;
import our.example.furniture.service.PostService;
import our.example.furniture.service.UploadInnerImages;
import our.example.furniture.service.UploadMainImage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;


@Controller
public class PostController {
    @Autowired
    private UploadInnerImages uploadInnerImages;
    @Autowired
    private UploadMainImage uploadMainImage;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;
    @Autowired
    private PostReviewService postReviewService;

    private Log log = LogFactory.getLog(this.getClass());

    // 상품 게시글 작성
    @PostMapping("/productRegister")
    public String productRegister(PostDTO postDTO, HttpSession session) throws Exception {
        String userLoginId = session.getAttribute("loginUser").toString();
        postDTO.setUserLoginId(userLoginId);
        postMapper.insertProductInfo(postDTO);
        // 메인 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(!postDTO.getProductMainImg().isEmpty()) {
            List<MainImageInfoDto> MainImageLogic = uploadMainImage.MainImageLogic(postDTO);
            postMapper.InsertMainImage(MainImageLogic);
        }

        // 내부 이미지에 요청값이 있는지 검사하고, DB에 값을 넣어주는 로직
        if(postDTO.getProductImg().length >= 1 && !postDTO.getProductImg()[0].isEmpty()) {
            List<InnerImagesInfoDto> InnerImageLogic = uploadInnerImages.InnerImagesLogic(postDTO);
            postMapper.InsertInnerImages(InnerImageLogic);
        }
        return "index";
    }

    // 상품 상세페이지
    @GetMapping("/postInfo")
    public String postInfo(@RequestParam("post_no") int post_no, PostDTO postDTO, ReviewDTO params, HttpServletResponse response, HttpServletRequest request, Model model) {
        postDTO.setProduct_no(post_no);
        params.setProduct_no(post_no);
        params.setRecordsPerPage(5);
        params.setIs_Post_no(true);
        params.getPost_no(post_no);
        int totalReviewNumThisPage = postMapper.selectPostReviewTotalCountThisPage(params);
        params.setTotal_review_num(totalReviewNumThisPage);
        PostDTO postInfo = postMapper.SelectPost(postDTO);
        List<PostDTO> postImages = postMapper.SelectPostImages(postDTO);
        // 이미지가 Null 일 경우, default 이미지로 null.gif 를 src 로 등록
        if(postInfo.getImg_url_main() == null) {
            String a = "img/null.gif";
            postInfo.setImg_url_main(a);
        }
        // 쿠키 조회
        String ViewCookieName = "ViewPostName" + postInfo.getProduct_no();
        Cookie[] cookies = request.getCookies();
        HashMap<String, String> CookieMap = new HashMap<String, String>();
        for(Cookie cookie:cookies) {
            CookieMap.put(cookie.getName(), cookie.getValue());
        }
        if(CookieMap.get(ViewCookieName) == null) {
            Cookie storeViewPostNameCookie = new Cookie(ViewCookieName, postInfo.getProductName());
            storeViewPostNameCookie.setMaxAge(60 * 60 * 24);
            storeViewPostNameCookie.setComment("Post 조회수 판별 쿠키(1일)");
            response.addCookie(storeViewPostNameCookie);
            postMapper.UpdateProductView(postInfo);
        }
        List<ReviewDTO> reviewInfo = postReviewService.getReviewList(params);
        model.addAttribute("postInfo", postInfo);
        model.addAttribute("params", params);
        model.addAttribute("postImages", postImages);
        model.addAttribute("reviewInfo", reviewInfo);
        return "postInfo";
    }

    // 댓글 요청값 저장-응답
    @ResponseBody
    @PostMapping("/postReviewInfo")
    public List<ReviewDTO> ReqReview(ReviewDTO params) {
        postMapper.WriteComment(params);
        List<ReviewDTO> reviewInfo = postReviewService.getReviewList(params);
        return reviewInfo;
    }

    // 댓글 수정
    @ResponseBody
    @PostMapping("/postReviewInfoFix")
    public String FixReview(ReviewFixDeleteDTO reviewFixDeleteDTO) {
        postMapper.UpdateComment(reviewFixDeleteDTO);
        String result = postMapper.ViewAfterUpdateComment(reviewFixDeleteDTO);
        return result;
    }

    // 댓글 삭제
    @ResponseBody
    @PostMapping("/postReviewInfoDelete")
    public String DeleteReview(ReviewFixDeleteDTO reviewFixDeleteDTO) {
        postMapper.DeleteComment(reviewFixDeleteDTO);
        String check = "댓글이 삭제되었습니다.";
        return check;
    }

    // 장바구니 등록
    @ResponseBody
    @PostMapping("/basketRegister")
    public String BasketRegister(int basketProductNum, HttpSession session) {
        session.setAttribute(String.valueOf(basketProductNum), basketProductNum);
        session.setMaxInactiveInterval(60*60);
        String result = "장바구니에 등록되었습니다.";
        return result;
    }

    // 장바구니 게시물 조회
    @GetMapping("/basket")
    public String basket(@ModelAttribute("params") PostDTO params, HttpSession session, Model model) {
        List<PostDTO> basketPostList = postService.getBasketPostList(params, session);
        model.addAttribute("basketPostList", basketPostList);
        return "basket";
    }

    // 장바구니 게시물 삭제
    @ResponseBody
    @PostMapping("/basketPostDelete")
    public String BasketPostDelete(int deletePostNum, HttpSession session) {
        List<Integer> deletePostNumList = new ArrayList<Integer>();
        deletePostNumList.add(deletePostNum);
        for(int i = 0; i < deletePostNumList.size(); i++) {
            String getBasketNumToString = deletePostNumList.get(i).toString();
            session.removeAttribute(getBasketNumToString);
        }
        return null;
    }
}
