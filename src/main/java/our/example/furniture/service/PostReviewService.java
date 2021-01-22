package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;
import our.example.furniture.dto.ReviewDTO;

import java.util.List;

public interface PostReviewService {
    public List<ReviewDTO> getReviewList(ReviewDTO params);
}
