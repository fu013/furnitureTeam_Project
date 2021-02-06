package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDto;

// 회원가입 관련 Mapper
@Mapper
public interface UserRegisterMapper {
	void insertUserRegister(UserRegisterDto userRegisterDto);
	String idOverlap(UserRegisterDto userRegisterDto);
	String emailOverlap(UserRegisterDto userRegisterDto);
	
	// 회원정보수정시 기존비밀번호를 한번 더 체크
	String passwordCheck(UserRegisterDto userRegisterDto);
	// 회원정보수정
	void userInfoChange(UserRegisterDto userRegisterDto);
	// 회원탈퇴
	void userInfoDelete(UserRegisterDto userRegisterDto);
}
