package our.example.furniture.dto;

    public class InnerImagesInfoDTO {
        private String saveImageName;
        private String extName;
        private Long FileSize;
        private String imgURL;

        // GETTER & SETTER
        public String getImgURL() { return imgURL; }

        public void setImgURL(String imgURL) { this.imgURL = imgURL; }

        public String getSaveImageName() {
            return saveImageName;
        }

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
