package com.application.social.media.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users", schema = "public")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @OneToMany(mappedBy = "user")
    private Set<PostEntity> posts = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "subscription_relations",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "subsriber_id") }
    )
    private Set<UserEntity> subscriptions;
    

    @ManyToMany
    @JoinTable(
        name = "friend_relations",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "friend_id") }
    )
    private Set<UserEntity> friend;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(
            userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
