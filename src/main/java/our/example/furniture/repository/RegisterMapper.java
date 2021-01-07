package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.RegisterDto;

// 회원가입 관련 Mapper
@Mapper
public interface RegisterMapper {
	void insertRegister(RegisterDto registerDto);
}
