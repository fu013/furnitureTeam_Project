package our.example.furniture.repository;

import our.example.furniture.dto.MainImageInfoDto;

import java.io.IOException;
import java.util.List;

public interface MainImageUploadMapper {
    void InsertMainImage(List<MainImageInfoDto> InnerImagesLogic) throws IOException;
}
