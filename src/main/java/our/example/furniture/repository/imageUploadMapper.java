package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.PostWriterDto;
import our.example.furniture.service.UploadImage;

import java.util.List;
import java.util.Map;

@Mapper
public interface imageUploadMapper {
    List<Map<String, Object>> restore(PostWriterDto postWriterDto);
}
