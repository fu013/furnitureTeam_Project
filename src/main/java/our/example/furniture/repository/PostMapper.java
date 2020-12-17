package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostWriterDto;

// @Mapper만 붙이면 마이바티스 xml과 매핑되는 빈즈 클래스가 된다.
@Mapper
public interface PostMapper {
    void insertAllName(PostWriterDto postWriterDto);
}