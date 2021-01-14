package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.*;
import our.example.furniture.paging.Pagination;

import java.io.IOException;
import java.util.List;

// 상품 게시물관련 Mapper
@Mapper
public interface PostMapper {

    // 게시물 작성시 - 데이터베이스에 데이터 추가하는 Method
    void insertProductInfo(PostWriterDto postWriterDto);
    void InsertInnerImages(List<InnerImagesInfoDto> InnerImagesLogic) throws IOException;
    void InsertMainImage(List<MainImageInfoDto> InnerImagesLogic) throws IOException;

    // 게시물 상세페이지에 데이터 조회하는 Method
    SelectedPostDto SelectPost(SelectedPostDto selectedPostDto);
    List<SelectedPostDto> SelectPostImages(SelectedPostDto selectedPostDto);

    // 게시물 조회 및 Pagination Method
    public List<SelectedPostDto> selectPostList(SelectedPostDto params);
    public int selectPostTotalCount(SelectedPostDto params);

    // 댓글 등록 & 조회
    void WriteComment(ReviewDto reviewDto);
    List<ReviewDto> ViewComment(ReviewDto reviewDto);
}
