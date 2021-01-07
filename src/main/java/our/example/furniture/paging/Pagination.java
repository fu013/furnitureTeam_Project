package our.example.furniture.paging;

public class Pagination {
    // 현재 페이지 번호
    private int currentPageNo;

    // 페이지당 출력할 데이터 개수
    private int recordsPerPage;

    // 화면 하단에 출력할 페이지 사이즈
    private int pageSize;

    // 검색 키워드
    private String searchKeyword;

    // 검색 유형
    private String searchType;

    // 생성자
    public Pagination() {
        this.currentPageNo = 1;
        this.recordsPerPage = 10;
        this.pageSize = 10;
    }

    // GETTER & SETTER
    public int getStartPage() {
        return (currentPageNo - 1) * recordsPerPage;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
