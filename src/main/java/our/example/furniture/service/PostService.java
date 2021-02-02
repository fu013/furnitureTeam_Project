package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface PostService {
    // 페이징이 적용된 게시물 리스트 가져오기
    public List<PostDTO> getPostList(PostDTO params);

    // 페이징이 적용된 최근 24시간안에 조회했던 게시물 리스트 가져오기
    public List<PostDTO> getViewPostList(PostDTO params, HttpServletResponse response, HttpServletRequest request);

    // 장바구니에 등록된 게시물 리스트 가져오기
    public List<PostDTO> getBasketPostList(PostDTO params, HttpSession session);

    // 페이징이 적용된 찜목록 리스트 가져오기
    public List<PostDTO> getDibsPostList(PostDTO params, HttpSession session);

}
