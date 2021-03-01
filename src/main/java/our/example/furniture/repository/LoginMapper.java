package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDTO;

@Mapper
public interface LoginMapper {
    // 로그인 요청 데이터 SELECT
    String overlapLogin(UserRegisterDTO userRegisterDto);
    // 아이디 찾기
    String findId(UserRegisterDTO userRegisterDto);
    // 비밀번호 찾기
    String findPassword(UserRegisterDTO userRegisterDto);
    // 비밀번호 수정
    String modifyPassword(UserRegisterDTO userRegisterDto);
}

