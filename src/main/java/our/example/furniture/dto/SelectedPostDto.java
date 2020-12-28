package our.example.furniture.dto;

public class SelectedPostDto {
    private int product_no;
    private String productCategory_HomeScale;
    private String productCategory_NumberOfHouseholds;
    private String productCategory_Interior;
    private String productName;
    private int productPrice;
    private String productGuideLine;
    private String productSize;
    private String productColor;
    private String productComment;

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public String getProductCategory_HomeScale() {
        return productCategory_HomeScale;
    }

    public void setProductCategory_HomeScale(String productCategory_HomeScale) {
        this.productCategory_HomeScale = productCategory_HomeScale;
    }

    public String getProductCategory_NumberOfHouseholds() {
        return productCategory_NumberOfHouseholds;
    }

    public void setProductCategory_NumberOfHouseholds(String productCategory_NumberOfHouseholds) {
        this.productCategory_NumberOfHouseholds = productCategory_NumberOfHouseholds;
    }

    public String getProductCategory_Interior() {
        return productCategory_Interior;
    }

    public void setProductCategory_Interior(String productCategory_Interior) {
        this.productCategory_Interior = productCategory_Interior;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductGuideLine() {
        return productGuideLine;
    }

    public void setProductGuideLine(String productGuideLine) {
        this.productGuideLine = productGuideLine;
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

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public void View() {
        System.out.println("key = 상품번호");
        System.out.println("value = " + product_no);
        System.out.println("key = 상품이름");
        System.out.println("value = " + productName);
    }
}
