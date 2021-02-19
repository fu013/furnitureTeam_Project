package our.example.furniture.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO extends CommonDTO {
    private int product_no;
    private String userLoginId;
    private String productCategoryHomeScale;
    private String productCategoryNumberOfHouseholds;
    private String productCategoryInterior;
    private String productName;
    private String productPrice;
    private String productGuideline;
    private String productSize;
    private String productColor;
    private MultipartFile productMainImg;
    private MultipartFile[] productImg;
    private String productComment;
    private String img_url_inner;
    private String img_url_main;
    private int productView;
    private int likeNum;
    private String searchN;

    // GETTER & SETTER

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

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

    public MultipartFile[] getProductImg() {
        return productImg;
    }

    public void setProductImg(MultipartFile[] productImg) {
        this.productImg = productImg;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public String getImg_url_inner() {
        return img_url_inner;
    }

    public void setImg_url_inner(String img_url_inner) {
        this.img_url_inner = img_url_inner;
    }

    public String getImg_url_main() {
        return img_url_main;
    }

    public void setImg_url_main(String img_url_main) {
        this.img_url_main = img_url_main;
    }

    public int getProductView() {
        return productView;
    }

    public void setProductView(int productView) {
        this.productView = productView;
    }

    public int getLikeNum() { return likeNum; }

    public void setLikeNum(int likeNum) { this.likeNum = likeNum; }

    public String getSearchN() {
        return searchN;
    }

    public void setSearchN(String searchN) {
        this.searchN = searchN;
    }
}
