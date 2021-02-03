package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface MyPageService {
    // 페이징이 적용된 찜목록 가져오기
    public List<PostDTO> getDibsPostList(PostDTO params, HttpSession session);
}
