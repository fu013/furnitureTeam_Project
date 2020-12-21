package our.example.furniture.service;

import org.springframework.stereotype.Component;
import our.example.furniture.dto.InnerImagesInfoDto;
import our.example.furniture.dto.MainImageInfoDto;
import our.example.furniture.dto.PostWriterDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 해당클래스를 bean 객체로 선언해주는 annotation
@Component
public class UploadMainImage {
    private static final String SAVE_PATH_MAIN = "/images/main";

    public List<MainImageInfoDto> MainImageLogic(PostWriterDto postWriterDto) throws IOException {

        // 메인 이미지 - 원래 이름
        String mainImgName = postWriterDto.getProductMainImg().getOriginalFilename();

        // 메인 이미지 - 파일 확장자 이름
        String extName = mainImgName.substring(mainImgName.lastIndexOf("."), mainImgName.length());

        // 메인 이미지 - 파일 사이즈
        long mainImgSize = postWriterDto.getProductMainImg().getSize();

        // 메인 이미지 - 서버에서 저장 할 파일 이름(고유값, 업로드 날짜의 밀리세컨즈로 이름을 정함)
        String saveFileName = UploadInnerImages.getSaveFileName(extName);

        List<MainImageInfoDto> MainImageList = new ArrayList<>();

        MainImageInfoDto mainImgDto = new MainImageInfoDto();
        mainImgDto.setSaveImageName(saveFileName);
        mainImgDto.setExtName(extName);
        mainImgDto.setFileSize(mainImgSize);
        MainImageList.add(mainImgDto);

        // 받은 이미지파일 폴더에 저장하는 Method
        UploadInnerImages.writeFile(postWriterDto, saveFileName, SAVE_PATH_MAIN);

        return MainImageList;
    }
}
