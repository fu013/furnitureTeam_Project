package our.example.furniture.repository;

import org.apache.ibatis.annotations.Mapper;
import our.example.furniture.dto.InnerImagesInfoDto;
import our.example.furniture.dto.MainImageInfoDto;
import our.example.furniture.dto.PostWriterDto;
import our.example.furniture.dto.SelectedPostDto;

import java.io.IOException;
import java.util.List;

// @Mapper 만 붙이면 마이바티스 xml 과 매핑되는 빈즈 클래스가 된다.
@Mapper
public interface PostMapper {
    void insertProductInfo(PostWriterDto postWriterDto);
    List<SelectedPostDto> SelectAllProduct();
    List<SelectedPostDto> SelectPostImages(SelectedPostDto selectedPostDto);
    SelectedPostDto SelectPost(SelectedPostDto selectedPostDto);
    void InsertInnerImages(List<InnerImagesInfoDto> InnerImagesLogic) throws IOException;
    void InsertMainImage(List<MainImageInfoDto> InnerImagesLogic) throws IOException;
}
