package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.*;

import java.io.IOException;
import java.util.List;

// 상품 게시물관련 Mapper
@Mapper
public interface PostMapper {

    // 게시물 작성시 - 데이터베이스에 데이터 추가하는 Method
    void insertProductInfo(PostDTO params);
    void InsertInnerImages(List<InnerImagesInfoDto> params) throws IOException;
    void InsertMainImage(List<MainImageInfoDto> params) throws IOException;

    // 게시물 상세페이지에 데이터 조회하는 Method
    PostDTO SelectPost(PostDTO params);
    List<PostDTO> SelectPostImages(PostDTO params);

    // 게시물 조회 및 Pagination Method
    List<PostDTO> selectPostList(PostDTO params);
    int selectPostTotalCount(PostDTO params);

    // 댓글 등록 & 조회
    void WriteComment(ReviewDTO params);
    List<ReviewDTO> ViewComment(ReviewDTO params);
    int selectPostReviewTotalCountThisPage(ReviewDTO params);

    // 댓글 수정 & 삭제
    void DeleteComment(ReviewFixDeleteDTO params);
    void UpdateComment(ReviewFixDeleteDTO params);
    String ViewAfterUpdateComment(ReviewFixDeleteDTO params);
}
