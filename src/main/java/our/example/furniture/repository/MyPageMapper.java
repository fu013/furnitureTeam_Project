package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostDTO;

import java.util.List;

// 마이페이지 Mapper
@Mapper
public interface MyPageMapper {

    // 찜목록 조회 & 등록 & 취소
    void InsertDibs(PostDTO params);
    void DeleteDibs(PostDTO params);
    int CheckDibs(PostDTO params);
    List<PostDTO> SelectDibsPost(PostDTO params);
    int SelectDibsPostCount(PostDTO params);

    // 좋아요 조회 & 등록 & 삭제
    void InsertLike(PostDTO params);
    void DeleteLike(PostDTO params);
    void UpdateLike(PostDTO params);
    int CheckLike(PostDTO params);
    List<PostDTO> SelectLikePost(PostDTO params);
    int SelectLikePostCount(PostDTO params);
}
