package our.example.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.paging.PaginationInfo;
import our.example.furniture.repository.PostMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@Service
public class PostServiceImpl implements PostService  {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostDTO> getPostList(PostDTO params) {

        List<PostDTO> postList = Collections.emptyList();
        int postTotalCount = postMapper.selectPostTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(postTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (postTotalCount > 0) {
            postList = postMapper.selectPostList(params);
        }

        return postList;
    }

    @Override
    public List<PostDTO> getViewPostList(PostDTO params, HttpServletResponse response, HttpServletRequest request) {

        List<Integer> cookiePostList = new ArrayList<Integer>();
        List<PostDTO> viewPostList = new ArrayList<PostDTO>();
        List<PostDTO> viewPostListOffsetApplied = new ArrayList<PostDTO>();

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies) {
            if(cookie.getName().contains("ViewPostName")) {
                String cookieGetNameString = cookie.getName().substring(12);
                int cookieGetNameToInt = Integer.parseInt(cookieGetNameString);
                cookiePostList.add(cookieGetNameToInt);
            }
        }
        for(int i = 0; i < cookiePostList.size(); i++) {
            params.setProduct_no(cookiePostList.get(i));
            PostDTO ViewPostDTO = postMapper.selectViewPostList(params);
            if(ViewPostDTO.getImg_url_main() == null) {
                String a = "img/null.gif";
                ViewPostDTO.setImg_url_main(a);
            }
            viewPostList.add(ViewPostDTO);
        }
        int viewPostTotalCount = viewPostList.size();


        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(viewPostTotalCount);
        params.setPaginationInfo(paginationInfo);
        int firstRecordIndex = paginationInfo.getFirstRecordIndex();
        int lastRecordIndex = paginationInfo.getLastRecordIndex();
        if (lastRecordIndex > viewPostTotalCount) {
            for (int i = firstRecordIndex; i < viewPostTotalCount; i++) {
                viewPostListOffsetApplied.add(viewPostList.get(i));
            }
        } else {
            for (int i = firstRecordIndex; i < lastRecordIndex; i++) {
                viewPostListOffsetApplied.add(viewPostList.get(i));
            }
        }
        return viewPostListOffsetApplied;
    }

    @Override
    public List<PostDTO> getBasketPostList(PostDTO params, HttpSession session) {

        Enumeration<String> SessionGetBasketEnum = session.getAttributeNames();
        List<PostDTO> basketPostList = new ArrayList<PostDTO>();
        List<PostDTO> basketPostListOffsetApplied = new ArrayList<PostDTO>();

        while(SessionGetBasketEnum.hasMoreElements()) {
            String stringBasketNum = SessionGetBasketEnum.nextElement();
            if(!stringBasketNum.contains("loginUser")) {
                int BasketNum = Integer.parseInt(stringBasketNum);
                params.setProduct_no(BasketNum);
                PostDTO BasketPostDTO = postMapper.selectViewPostList(params);
                if(BasketPostDTO.getImg_url_main() == null) {
                    String a = "img/null.gif";
                    BasketPostDTO.setImg_url_main(a);
                }
                basketPostList.add(BasketPostDTO);
            }
        }
        int basketPostListTotalCount = basketPostList.size();

        params.setRecordsPerPage(5);
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(basketPostListTotalCount);
        params.setPaginationInfo(paginationInfo);
        int firstRecordIndex = paginationInfo.getFirstRecordIndex();
        int lastRecordIndex = paginationInfo.getLastRecordIndex();
        if (lastRecordIndex > basketPostListTotalCount) {
            for (int i = firstRecordIndex; i < basketPostListTotalCount; i++) {
                basketPostListOffsetApplied.add(basketPostList.get(i));
            }
        } else {
            for (int i = firstRecordIndex; i < lastRecordIndex; i++) {
                basketPostListOffsetApplied.add(basketPostList.get(i));
            }
        }
        return basketPostListOffsetApplied;
    }
}
