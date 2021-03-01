package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.UserRegisterDTO;

// 회원가입 관련 Mapper
@Mapper
public interface UserRegisterMapper {
	void insertUserRegister(UserRegisterDTO userRegisterDto);
	String idOverlap(UserRegisterDTO userRegisterDto);
	String emailOverlap(UserRegisterDTO userRegisterDto);
	
	// 회원정보수정시 기존비밀번호를 한번 더 체크
	String passwordCheck(UserRegisterDTO userRegisterDto);
	// 회원정보수정
	void userInfoChange(UserRegisterDTO userRegisterDto);
	// 회원탈퇴
	void userInfoDelete(UserRegisterDTO userRegisterDto);
	// 회원수정 - 유저정보
	UserRegisterDTO selectUserTable(UserRegisterDTO userRegisterDto);
}
