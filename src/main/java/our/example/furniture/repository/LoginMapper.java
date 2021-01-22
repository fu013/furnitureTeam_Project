package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;

import our.example.furniture.dto.UserRegisterDto;

@Mapper
public interface LoginMapper {
    String overlapLogin(UserRegisterDto userRegisterDto);
}

