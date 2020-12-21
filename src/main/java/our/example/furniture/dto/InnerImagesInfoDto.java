package our.example.furniture.dto;

    public class InnerImagesInfoDto {
        private String saveImageName;
        private String extName;
        private Long FileSize;

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
