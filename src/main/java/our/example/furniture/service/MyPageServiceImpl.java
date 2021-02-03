package our.example.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.paging.PaginationInfo;
import our.example.furniture.repository.MyPageMapper;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService{
    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public List<PostDTO> getDibsPostList(PostDTO params, HttpSession session) {

        params.setUserLoginId(session.getAttribute("loginUser").toString());
        List<PostDTO> dibsList = Collections.emptyList();
        int dibsTotalCount = myPageMapper.selectDibsPostTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(dibsTotalCount);

        params.setPaginationInfo(paginationInfo);

        if(dibsTotalCount > 0) {
            dibsList = myPageMapper.selectDibsPost(params);
        }
        for(int i = 0; i < dibsList.size(); i++) {
            if (dibsList.get(i).getImg_url_main() == null) {
                String a = "img/null.gif";
                dibsList.get(i).setImg_url_main(a);
            }
        }
        return dibsList;
    }
}
