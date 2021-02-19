package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDto;

@Mapper
public interface LoginMapper {
    // 로그인 요청 데이터 SELECT
    String overlapLogin(UserRegisterDto userRegisterDto);
    // 아이디 찾기
    String findId(UserRegisterDto userRegisterDto);
    // 비밀번호 찾기
    String findPassword(UserRegisterDto userRegisterDto);
    // 비밀번호 수정
    String modifyPassword(UserRegisterDto userRegisterDto);
}

