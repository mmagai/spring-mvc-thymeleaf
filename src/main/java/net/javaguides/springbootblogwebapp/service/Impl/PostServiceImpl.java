package net.javaguides.springbootblogwebapp.service.Impl;

import net.javaguides.springbootblogwebapp.dto.PostDto;
import net.javaguides.springbootblogwebapp.entity.Post;

import net.javaguides.springbootblogwebapp.mapper.PostMapper;
import net.javaguides.springbootblogwebapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> finalAll() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map((post)-> PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.mapPostDtoEntityToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto findById(Long postId) {

        Post post = postRepository.findById(postId).get();
        return  PostMapper.mapPostEntityToPostDto(post);

    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> postList = postRepository.searchPosts(query);
        return postList.stream().map((post)->
                PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }


}
