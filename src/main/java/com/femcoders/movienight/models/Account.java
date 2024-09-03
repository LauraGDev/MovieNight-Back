package com.femcoders.movienight.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private String name;
    private String profile_photo;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_content",
            joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id",
                    referencedColumnName = "id"))
    private List<Content> content;

    public Account() {
    }
}
