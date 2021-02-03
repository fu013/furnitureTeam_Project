package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostDTO;

import java.util.List;

// 마이페이지 Mapper
@Mapper
public interface MyPageMapper {

    // 찜목록 등록
    void InsertDibs(PostDTO params);

    // 찜목록 중복 확인
    int CheckDibs(PostDTO params);

    // 찜목록 Select
    List<PostDTO> selectDibsPost(PostDTO params);

    // 찜목록 조회 및 Pagination Method
    int selectDibsPostTotalCount(PostDTO params);
}
