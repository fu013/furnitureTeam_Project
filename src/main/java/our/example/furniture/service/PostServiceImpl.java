package our.example.furniture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import our.example.furniture.dto.SelectedPostDto;
import our.example.furniture.paging.PaginationInfo;
import our.example.furniture.repository.PostMapper;
import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService  {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<SelectedPostDto> getPostList(SelectedPostDto selectedPostDto) {

        List<SelectedPostDto> postList = Collections.emptyList();
        int postTotalCount = postMapper.selectPostTotalCount(selectedPostDto);

        PaginationInfo paginationInfo = new PaginationInfo(selectedPostDto);
        paginationInfo.setTotalRecordCount(postTotalCount);

        selectedPostDto.setPaginationInfo(paginationInfo);

        if (postTotalCount > 0) {
            postList = postMapper.selectPostList(selectedPostDto);
        }

        return postList;
    }
}
