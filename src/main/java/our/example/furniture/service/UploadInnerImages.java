package our.example.furniture.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import our.example.furniture.dto.InnerImagesInfoDto;
import our.example.furniture.dto.PostWriterDto;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

// 해당클래스를 bean 객체로 선언해주는 annotation
@Component
public class UploadInnerImages {
    // 로그 객체 생성
    private Log log = LogFactory.getLog(this.getClass());

    // 이너 이미지(다중) - 경로
    private static final String SAVE_PATH_INNER = "/images/inner";

    // 이미지이름 날짜데이터로 고유값 만들어서 새로 저장하는 Method
    public static String getSaveFileName(String extName) {
        String fileName = "";
        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += extName;
        return fileName;
    }

    // 메인 이미지(단일) 파일 images/main 폴더에 데이터 저장
    public static boolean writeFile(PostWriterDto postWriterDto, String saveFileName, String SAVE_PATH) throws IOException {
        byte[] data = postWriterDto.getProductMainImg().getBytes();
        FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
        fos.write(data);
        fos.close();
        return false;
    }


    public List<InnerImagesInfoDto> InnerImagesLogic(PostWriterDto postWriterDto) throws IOException {

        // 이너 이미지 배열 형식으로 데이터 받아오기
        MultipartFile[] images = postWriterDto.getProductImg();

        // 이너 이미지(다중) - 데이터 담을 리스트(HashMap Data) 생성
        List<InnerImagesInfoDto> imagesList = new ArrayList<>();


        for (int i = 0; i < images.length; i++) {
            // Dto 생성
            InnerImagesInfoDto imageInfoDto = new InnerImagesInfoDto();

            // 이너 이미지(다중) - 원래 이름
            String innerImagesName = images[i].getOriginalFilename();
            // 이너 이미지(다중) - 파일 확장자 이름
            String extNameInner = innerImagesName.substring(innerImagesName.lastIndexOf("."), innerImagesName.length());
            // 이너 이미지(다중) - 파일 사이즈
            Long saveFileSize = images[i].getSize();
            // 이너 이미지(다중) - 서버에서 저장 할 파일 이름(고유값, 업로드 날짜의 밀리세컨즈로 이름을 정함)
            String saveFileNameInner = getSaveFileName(extNameInner);
            // 이미지 경로 + 네임
            String imgURL = "/inner/" + saveFileNameInner;

            imageInfoDto.setSaveImageName(saveFileNameInner);
            imageInfoDto.setExtName(extNameInner);
            imageInfoDto.setFileSize(saveFileSize);
            imageInfoDto.setImgURL(imgURL);

            imagesList.add(imageInfoDto);

            // 이너 이미지(다중) 파일 images/inner 폴더에 데이터 저장
            byte[] data = images[i].getBytes();
            FileOutputStream fos = new FileOutputStream(SAVE_PATH_INNER +saveFileNameInner);
            fos.write(data);
            fos.close();
        }

        // imagesList 에 데이터가 잘들어왔는지 검사하는 로직
        /*
        for(int i = 0; i < imagesList.size(); i++){
            log.info(imagesList.get(i));
        }
        */
        return imagesList;
    }
}
