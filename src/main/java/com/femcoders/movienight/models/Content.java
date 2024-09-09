package com.femcoders.movienight.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String title;
    private String original_title;
    @Column(columnDefinition = "TEXT")
    private String summary;
    private String director;
    private String creator;
    private String release_date;
    private int length;
    private int seasons;
    @Column(nullable = false)
    private String poster_path;
    private String backdrop_path;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "content_genres",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "content_id",
                    referencedColumnName = "id"))
    private List<Genre> genres;
    @ManyToMany(mappedBy = "content")
    private List<Profile> profiles;

    public Content() {
    }
}
