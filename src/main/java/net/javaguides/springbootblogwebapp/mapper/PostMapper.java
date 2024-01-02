package net.javaguides.springbootblogwebapp.mapper;

import net.javaguides.springbootblogwebapp.dto.PostDto;
import net.javaguides.springbootblogwebapp.entity.Post;

public class PostMapper {

    public static PostDto mapPostEntityToPostDto(Post post){

     return PostDto.builder()
             .id(post.getId())
             .content(post.getContent())
             .url(post.getUrl())
             .title(post.getTitle())
             .shortDescription(post.getShortDescription())
             .createdOn(post.getCreateOn())
             .updatedOn(post.getUpdateOn())
             .build();


    }

    public static Post mapPostDtoEntityToPost(PostDto postDto){

        return Post.builder()
                .id(postDto.getId())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .title(postDto.getTitle())
                .shortDescription(postDto.getShortDescription())
                .createOn(postDto.getCreatedOn())
                .updateOn(postDto.getUpdatedOn())
                .build();


    }
}
