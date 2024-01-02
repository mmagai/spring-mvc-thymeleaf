package net.javaguides.springbootblogwebapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String url;

    @Lob
    @Column(nullable = false)
    private String content;

    private String shortDescription;


    @CreationTimestamp
    private LocalDateTime createOn;


    @CreationTimestamp
    private LocalDateTime updateOn;


}
