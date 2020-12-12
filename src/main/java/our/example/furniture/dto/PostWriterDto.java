package our.example.furniture.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostWriterDto {
    private String productCategoryHomeScale;
    private String productCategoryNumberOfHouseholds;
    private String productCategoryInterior;
    private String productName;
    private String productPrice;
    private String productGuideline;
    private String productSize;
    private String productColor;
    private MultipartFile productMainImg;
    private MultipartFile productImg;
    private String productComment;

    public String getProductCategoryHomeScale() {
        return productCategoryHomeScale;
    }

    public void setProductCategoryHomeScale(String productCategoryHomeScale) {
        this.productCategoryHomeScale = productCategoryHomeScale;
    }

    public String getProductCategoryNumberOfHouseholds() {
        return productCategoryNumberOfHouseholds;
    }

    public void setProductCategoryNumberOfHouseholds(String productCategoryNumberOfHouseholds) {
        this.productCategoryNumberOfHouseholds = productCategoryNumberOfHouseholds;
    }

    public String getProductCategoryInterior() {
        return productCategoryInterior;
    }

    public void setProductCategoryInterior(String productCategoryInterior) {
        this.productCategoryInterior = productCategoryInterior;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductGuideline() {
        return productGuideline;
    }

    public void setProductGuideline(String productGuideline) {
        this.productGuideline = productGuideline;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public MultipartFile getProductMainImg() {
        return productMainImg;
    }

    public void setProductMainImg(MultipartFile productMainImg) {
        this.productMainImg = productMainImg;
    }

    public MultipartFile getProductImg() {
        return productImg;
    }

    public void setProductImg(MultipartFile productImg) {
        this.productImg = productImg;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }
}
