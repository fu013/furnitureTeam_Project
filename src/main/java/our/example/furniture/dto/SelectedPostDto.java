package our.example.furniture.dto;

public class SelectedPostDto extends CommonDto {
    private int product_No;
    private String productCategory_HomeScale;
    private String productCategory_NumberOfHouseholds;
    private String productCategory_Interior;
    private String productName;
    private int productPrice;
    private String img_url_inner;
    private String img_url_main;

    // GETTER & SETTER
    public int getProduct_No() {
        return product_No;
    }

    public void setProduct_No(int product_No) {
        this.product_No = product_No;
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
}
