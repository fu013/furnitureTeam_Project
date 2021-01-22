package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;
import our.example.furniture.dto.ReviewDTO;

import java.util.List;

public interface PostReviewService {
    // 페이징이 적용된 게시물별 댓글 리스트 가져오기
    public List<ReviewDTO> getReviewList(ReviewDTO params);
}
