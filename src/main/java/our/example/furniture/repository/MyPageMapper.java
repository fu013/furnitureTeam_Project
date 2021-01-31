package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostDTO;

// 마이페이지 Mapper
@Mapper
public interface MyPageMapper {

    // 찜목록 등록 & 취소
    void InsertDibs(PostDTO params);
    int CheckDibs(PostDTO params);
    void SelectPostList(PostDTO params);
}
