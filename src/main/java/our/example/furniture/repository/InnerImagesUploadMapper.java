package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.InnerImagesInfoDto;

import java.io.IOException;
import java.util.List;

@Mapper
public interface InnerImagesUploadMapper {
    void InsertInnerImages(List<InnerImagesInfoDto> InnerImagesLogic) throws IOException;
}
