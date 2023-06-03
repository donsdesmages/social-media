package com.application.social.media.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "post", schema = "public")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_post")
    private String namePost;

    @Column(name = "heading_post")
    private String heading;

    @Column(name = "image_url")
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostEntity)) return false;
        PostEntity entity = (PostEntity) o;
        return Objects.equals(id, entity.id)
            && Objects.equals(namePost, entity.namePost)
            && Objects.equals(heading, entity.heading)
            && Objects.equals(user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namePost, heading, user);
    }
}
