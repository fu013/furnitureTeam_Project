package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;

import java.util.List;

public interface PostService {
    public List<PostDTO> getPostList(PostDTO params);
}
