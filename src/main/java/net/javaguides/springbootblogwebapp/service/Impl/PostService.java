package net.javaguides.springbootblogwebapp.service.Impl;

import net.javaguides.springbootblogwebapp.dto.PostDto;
import net.javaguides.springbootblogwebapp.entity.Post;

import java.util.List;

public interface PostService {

    public List<PostDto> finalAll();
    void createPost(PostDto postDto);

    PostDto findById(Long postId);



    void deletePostById(Long postId);

    List<PostDto> searchPosts(String query);
}
