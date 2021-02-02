package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostDTO;

import java.util.List;

// 마이페이지 Mapper
@Mapper
public interface MyPageMapper {

    // 찜목록 등록 & 취소
    void InsertDibs(PostDTO params);
    int CheckDibs(PostDTO params);
    List<PostDTO> SelectDibsPost(PostDTO params);
    int SelectDibsPostCount(PostDTO params);

    // 좋아요 등록 & 삭제
    void InsertLike(PostDTO params);
    int CheckLike(PostDTO params);
}
