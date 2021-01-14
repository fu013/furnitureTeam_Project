package our.example.furniture.dto;

public class ReviewDto {
    private int product_no;
    private String review_userNickname;
    private String review_comment;
    private String review_size;
    private String review_satisfaction;
    private String current_date;

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public String getReview_userNickname() {
        return review_userNickname;
    }

    public void setReview_userNickname(String review_userNickname) {
        this.review_userNickname = review_userNickname;
    }

    public String getReview_satisfaction() {
        return review_satisfaction;
    }

    public void setReview_satisfaction(String review_satisfaction) {
        this.review_satisfaction = review_satisfaction;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }

    public String getReview_size() {
        return review_size;
    }

    public void setReview_size(String review_size) {
        this.review_size = review_size;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
}
