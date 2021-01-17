package our.example.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.example.furniture.dto.PostDTO;
import our.example.furniture.paging.PaginationInfo;
import our.example.furniture.repository.PostMapper;
import java.util.Collections;
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
}
