package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.SelectedPostDto;

import java.util.List;

@Mapper
public interface SelectPostMapper {
    SelectedPostDto SelectPost(SelectedPostDto selectedPostDto);
}
