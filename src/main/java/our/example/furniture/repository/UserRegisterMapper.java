package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDto;

// 회원가입 관련 Mapper
@Mapper
public interface UserRegisterMapper {
	// 회원가입정보 INSERT
	void insertUserRegister(UserRegisterDto userRegisterDto);
	// 중복확인 ID값 SELECT
	String idOverlap(UserRegisterDto userRegisterDto);
}
