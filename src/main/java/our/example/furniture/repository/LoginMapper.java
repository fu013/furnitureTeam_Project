package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDto;

@Mapper
public interface LoginMapper {
    // 로그인 요청 데이터 SELECT
    String overlapLogin(UserRegisterDto userRegisterDto);
}

