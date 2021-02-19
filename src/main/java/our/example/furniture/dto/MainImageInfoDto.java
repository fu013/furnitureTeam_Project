package our.example.furniture.dto;

public class MainImageInfoDto {
    private String saveImageName;
    private String extName;
    private Long FileSize;
    private String imgURL;

    // GETTER & SETTER
    public String getSaveImageName() {
        return saveImageName;
    }

    public String getImgURL() { return imgURL; }

    public void setImgURL(String imgURL) { this.imgURL = imgURL; }

    public void setSaveImageName(String saveImageName) {
        this.saveImageName = saveImageName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Long getFileSize() {
        return FileSize;
    }

    public void setFileSize(Long fileSize) {
        FileSize = fileSize;
    }
}
