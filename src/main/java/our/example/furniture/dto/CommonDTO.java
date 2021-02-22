package our.example.furniture.dto;

import our.example.furniture.page.Pagination;
import our.example.furniture.page.PaginationInfo;

import java.time.LocalDateTime;

public class CommonDTO extends Pagination {
    // 페이징 정보
    private PaginationInfo paginationInfo;

    // 삭제 여부
    private String deleteYn;

    // 좋아요 여부
    private boolean likeYn;

    // 찜 여부
    private boolean dibYn;

    // 장바구니 여부
    private boolean basketYn;

    // 등록일
    private LocalDateTime insertTime;

    // 수정일
    private LocalDateTime updateTime;

    // 삭제일
    private LocalDateTime deleteTime;

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public boolean isLikeYn() {
        return likeYn;
    }

    public void setLikeYn(boolean likeYn) {
        this.likeYn = likeYn;
    }

    public boolean isDibYn() {
        return dibYn;
    }

    public void setDibYn(boolean dibYn) {
        this.dibYn = dibYn;
    }

    public boolean isBasketYn() {
        return basketYn;
    }

    public void setBasketYn(boolean basketYn) {
        this.basketYn = basketYn;
    }
}
