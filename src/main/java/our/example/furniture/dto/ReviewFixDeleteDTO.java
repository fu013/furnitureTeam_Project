package our.example.furniture.dto;

public class ReviewFixDeleteDTO {
    private int delete_comment_no;
    private int fix_comment_no;
    private String fixed_review_comment;

    public int getDelete_comment_no() {
        return delete_comment_no;
    }

    public void setDelete_comment_no(int delete_comment_no) {
        this.delete_comment_no = delete_comment_no;
    }

    public int getFix_comment_no() {
        return fix_comment_no;
    }

    public void setFix_comment_no(int fix_comment_no) {
        this.fix_comment_no = fix_comment_no;
    }

    public String getFixed_review_comment() {
        return fixed_review_comment;
    }

    public void setFixed_review_comment(String fixed_review_comment) {
        this.fixed_review_comment = fixed_review_comment;
    }
}
