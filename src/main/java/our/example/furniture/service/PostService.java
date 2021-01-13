package our.example.furniture.service;

import our.example.furniture.dto.SelectedPostDto;
import java.util.List;

public interface PostService {
    public List<SelectedPostDto> getPostList(SelectedPostDto params);
}
