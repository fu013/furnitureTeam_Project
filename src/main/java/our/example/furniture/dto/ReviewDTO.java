package our.example.furniture.dto;

public class ReviewDTO extends CommonDTO {
    private int product_no;
    private int comment_no;
    private String review_userNickname;
    private String review_comment;
    private String review_size;
    private String review_satisfaction;
    private String review_color;
    private String create_date;
    private int total_review_num;

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

    public String getReview_color() {
        return review_color;
    }

    public void setReview_color(String review_color) {
        this.review_color = review_color;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getTotal_review_num() {
        return total_review_num;
    }

    public void setTotal_review_num(int total_review_num) {
        this.total_review_num = total_review_num;
    }

    public int getComment_no() {
        return comment_no;
    }

    public void setComment_no(int comment_no) {
        this.comment_no = comment_no;
    }
}
