package net.javaguides.springbootblogwebapp.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id;
    @NotEmpty(message = "Title must not be empty")
    private String title;
    private String url;

    @NotEmpty(message = "Content must not be Empty")
    private String content;

    @NotEmpty(message = "ShortDescription must not be Empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
