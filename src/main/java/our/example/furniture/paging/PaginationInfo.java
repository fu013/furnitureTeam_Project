package our.example.furniture.paging;

public class PaginationInfo {

    // 페이징 계산에 필요한 파라미터들이 담긴 클래스
    private Pagination pagination;

    //전체 데이터 개수 */
    private int totalRecordCount;

    //전체 페이지 개수 */
    private int totalPageCount;

    //페이지 리스트의 첫 페이지 번호 */
    private int firstPage;

    // 페이지 리스트의 마지막 페이지 번호 */
    private int lastPage;

    // SQL의 조건절에 사용되는 첫 RNUM */
    private int firstRecordIndex;

    // SQL의 조건절에 사용되는 마지막 RNUM */
    private int lastRecordIndex;

    // 이전 페이지 존재 여부 */
    private boolean hasPreviousPage;

    // 다음 페이지 존재 여부 */
    private boolean hasNextPage;

    public PaginationInfo(Pagination pagination) {
        if (pagination.getCurrentPageNo() < 1) {
            pagination.setCurrentPageNo(1);
        }
        if (pagination.getRecordsPerPage() < 1 || pagination.getRecordsPerPage() > 50) {
            pagination.setRecordsPerPage(5);
        }
        if (pagination.getPageSize() < 5 || pagination.getPageSize() > 10) {
            pagination.setPageSize(5);
        }

        this.pagination = pagination;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;

        if (totalRecordCount > 0) {
            calculation();
        }
    }

    private void calculation() {

        /* 전체 페이지 수 (현재 페이지 번호가 전체 페이지 수보다 크면 현재 페이지 번호에 전체 페이지 수를 저장) */
        totalPageCount = ((totalRecordCount - 1) / pagination.getRecordsPerPage()) + 1;
        if (pagination.getCurrentPageNo() > totalPageCount) {
            pagination.setCurrentPageNo(totalPageCount);
        }

        /* 페이지 리스트의 첫 페이지 번호 */
        firstPage = ((pagination.getCurrentPageNo() - 1) / pagination.getPageSize()) * pagination.getPageSize() + 1;

        /* 페이지 리스트의 마지막 페이지 번호 (마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장) */
        lastPage = firstPage + pagination.getPageSize() - 1;
        if (lastPage > totalPageCount) {
            lastPage = totalPageCount;
        }

        /* SQL의 조건절에 사용되는 첫 RNUM */
        firstRecordIndex = (pagination.getCurrentPageNo() - 1) * pagination.getRecordsPerPage();

        /* SQL의 조건절에 사용되는 마지막 RNUM */
        lastRecordIndex = pagination.getCurrentPageNo() * pagination.getRecordsPerPage();

        /* 이전 페이지 존재 여부 */
        hasPreviousPage = firstPage != 1;

        /* 다음 페이지 존재 여부 */
        hasNextPage = (lastPage * pagination.getRecordsPerPage()) < totalRecordCount;
    }

    // GETTER & SETTER
    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getFirstRecordIndex() {
        return firstRecordIndex;
    }

    public void setFirstRecordIndex(int firstRecordIndex) {
        this.firstRecordIndex = firstRecordIndex;
    }

    public int getLastRecordIndex() {
        return lastRecordIndex;
    }

    public void setLastRecordIndex(int lastRecordIndex) {
        this.lastRecordIndex = lastRecordIndex;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}