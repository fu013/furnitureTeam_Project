package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;

import our.example.furniture.dto.UserRegisterDto;

@Mapper
public interface LoginMapper {
<<<<<<< HEAD
    UserRegisterDto overlapLogin(UserRegisterDto userRegisterDto);
}
=======
    String overlapLogin(UserRegisterDto userRegisterDto);
}
>>>>>>> sb
