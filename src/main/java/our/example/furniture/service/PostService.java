package our.example.furniture.service;

import our.example.furniture.dto.PostDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PostService {
    public List<PostDTO> getPostList(PostDTO params);
    public List<PostDTO> getViewPostList(PostDTO params, HttpServletResponse response, HttpServletRequest request);
}
