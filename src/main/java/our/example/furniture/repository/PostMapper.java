package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.InnerImagesInfoDto;
import our.example.furniture.dto.MainImageInfoDto;
import our.example.furniture.dto.PostWriterDto;
import our.example.furniture.dto.SelectedPostDto;
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

    // 게시물 인덱스 페이지에 데이터 조회하는 Method
    List<SelectedPostDto> SelectAllProduct();

    // 게시물 상세페이지에 데이터 조회하는 Method
    SelectedPostDto SelectPost(SelectedPostDto selectedPostDto);
    List<SelectedPostDto> SelectPostImages(SelectedPostDto selectedPostDto);

    // 게시물 Pagination Method
    public List<SelectedPostDto> selectPostList(Pagination pagination);
    public int selectPostTotalCount(Pagination pagination);

}
