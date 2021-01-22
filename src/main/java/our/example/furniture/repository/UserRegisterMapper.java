package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDto;

// 회원가입 관련 Mapper
@Mapper
public interface UserRegisterMapper {
	void insertUserRegister(UserRegisterDto userRegisterDto);
	String idOverlap(UserRegisterDto userRegisterDto);
}
