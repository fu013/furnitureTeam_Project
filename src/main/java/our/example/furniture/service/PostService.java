package our.example.furniture.service;

import our.example.furniture.dto.SelectedPostDto;
import our.example.furniture.paging.Pagination;
import java.util.List;

public interface PostService {
    public List<SelectedPostDto> getPostList(SelectedPostDto params);
}
