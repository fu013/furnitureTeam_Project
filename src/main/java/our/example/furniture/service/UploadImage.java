package our.example.furniture.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;
import our.example.furniture.dto.PostWriterDto;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


@Component
public class UploadImage {
    // 로그 객체 생성
    private Log log = LogFactory.getLog(this.getClass());

    // 메인 이미지 - 경로
    private static final String SAVE_PATH_MAIN = "/images/main";
    // 이너 이미지(다중) - 경로
    private static final String SAVE_PATH_INNER = "/images/inner";

    public void restore(PostWriterDto postWriterDto) throws IOException {
        // 메인 이미지 - 원래 이름
        String mainImgName = postWriterDto.getProductMainImg().getOriginalFilename();
        // 메인 이미지 - 파일 확장자 이름
        String extName = mainImgName.substring(mainImgName.lastIndexOf("."), mainImgName.length());
        // 메인 이미지 - 파일 사이즈
        long mainImgSize = postWriterDto.getProductMainImg().getSize();
        // 메인 이미지 - 서버에서 저장 할 파일 이름(고유값, 업로드 날짜의 밀리세컨즈로 이름을 정함)
        String saveFileName = getSaveFileName(extName);

        // 메인 이미지 - 콘솔 확인
        log.info("===================================");
        log.info("mainImgName : " + mainImgName);
        log.info("extensionName : " + extName);
        log.info("mainImgSize : " + mainImgSize);
        log.info("saveFileName : " + saveFileName);

        // 메인 이미지 - 파일 저장하는 Method writeFile
        writeFile(postWriterDto, saveFileName, SAVE_PATH_MAIN);

        // 이너 이미지(다중) - 데이터 배열형태로 가져오기
        MultipartFile[] images = postWriterDto.getProductImg();

        // 이너 이미지(다중) - 데이터 담을 리스트 생성
        List<Map<String, Object>> imagesList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < images.length; i++) {
            // 이너 이미지(다중) - 원래 이름
            String innerImagesName = images[i].getOriginalFilename();
            // 이너 이미지(다중) - 파일 확장자 이름
            String extNameInner = innerImagesName.substring(innerImagesName.lastIndexOf("."), innerImagesName.length());
            // 이너 이미지(다중) - 파일 사이즈
            Long saveFileSize = images[i].getSize();
            // 이너 이미지(다중) - 서버에서 저장 할 파일 이름(고유값, 업로드 날짜의 밀리세컨즈로 이름을 정함)
            String saveFileNameInner = getSaveFileName(extNameInner);

            Map<String, Object> imagesInfo = new HashMap<String, Object>();
            imagesInfo.put("innerImagesName", innerImagesName);
            imagesInfo.put("extNameInner",extNameInner);
            imagesInfo.put("saveFileSize", saveFileSize);
            imagesInfo.put("saveFileNameInner", saveFileNameInner);
            imagesList.add(imagesInfo);
        }
    }


    // 이미지이름 날짜데이터로 고유값 만들어서 새로 저장하는 Method
    private String getSaveFileName(String extName) {
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

    // 이미지 - 파일 데이터를 실제 경로에 저장하는 Method
    private boolean writeFile(PostWriterDto postWriterDto, String saveFileName, String SAVE_PATH) throws IOException {
            byte[] data = postWriterDto.getProductMainImg().getBytes();
            FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
            fos.write(data);
            fos.close();
            return false;
    }

    // 이너 이미지 - 파일 데이터를 실제 경로에 저장하는 Method 따로 만들기 data 가 다름
}
