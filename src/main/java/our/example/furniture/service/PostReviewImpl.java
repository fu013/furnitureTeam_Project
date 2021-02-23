package our.example.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.example.furniture.dto.ReviewDTO;
import our.example.furniture.page.PaginationInfo;
import our.example.furniture.repository.PostMapper;
import java.util.Collections;
import java.util.List;

@Service
public class PostReviewImpl implements PostReviewService  {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<ReviewDTO> getReviewList(ReviewDTO params) {
        List<ReviewDTO> postReviewList = Collections.emptyList();
        int postReviewTotalCount = postMapper.selectPostReviewTotalCountThisPage(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(postReviewTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (postReviewTotalCount > 0) {
            postReviewList = postMapper.ViewComment(params);
        }

        return postReviewList;
    }
}
