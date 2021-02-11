package our.example.furniture.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Pagination {
    // 현재 페이지 번호
    private int currentPageNo;

    // 페이지당 출력할 데이터 개수
    private int recordsPerPage;

    // 화면 하단에 출력할 페이지 사이즈
    private int pageSize;

    // 검색 카테고리 - 1
    private String cat1;

    // 검색 카테고리 - 2
    private String cat2;

    // 검색 카테고리 - 3
    private String cat3;

    // 최소 가격
    private int minPrice;

    // 최대 가격
    private int maxPrice;

    // 검색 유형
    private String searchType;

    // post_no 존재유무
    private boolean Is_Post_no;

    // 게시물 post_no
    private int post_no;

    // 생성자
    public Pagination() {
        this.currentPageNo = 1;
        this.recordsPerPage = 9;
        this.pageSize = 10;
    }

    // 스프링에서 제공해주는 UriComponents 클래스를 사용하면 URI 를 더욱 효율적으로 처리할 수 있다. <쿼리스트링 생성>
    public String makeQueryString(int pageNo, String searchType, String cat1, String cat2, String cat3, int minPrice, int maxPrice) {
        UriComponents uriComponents;
        if (!Is_Post_no) {
            uriComponents = UriComponentsBuilder.newInstance()
                    .queryParam("currentPageNo", pageNo)
                    .queryParam("recordsPerPage", recordsPerPage)
                    .queryParam("pageSize", pageSize)
                    .queryParam("searchType", searchType)
                    .queryParam("cat1", cat1)
                    .queryParam("cat2", cat2)
                    .queryParam("cat3", cat3)
                    .queryParam("minPrice", minPrice)
                    .queryParam("maxPrice", maxPrice)
                    .build()
                    .encode();
        } else {
            uriComponents = UriComponentsBuilder.newInstance()
                    .queryParam("post_no", post_no)
                    .queryParam("currentPageNo", pageNo)
                    .queryParam("recordsPerPage", recordsPerPage)
                    .queryParam("pageSize", pageSize)
                    .build()
                    .encode();
        }
        return uriComponents.toUriString();
    }

    // GETTER & SETTER
    public int getStartPage() {
        // StartPage 값
        return (currentPageNo - 1) * recordsPerPage;
    }

    public int getCurrentPageNo() { return currentPageNo; }

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

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public boolean isIs_Post_no() {
        return Is_Post_no;
    }

    public void setIs_Post_no(boolean is_Post_no) {
        Is_Post_no = is_Post_no;
    }

    public int getPost_no(int post_no) {
        return this.post_no;
    }

    public void setPost_no(int post_no) {
        this.post_no = post_no;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public int getPost_no() {
        return post_no;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}
