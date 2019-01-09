package mk.ukim.finki.wp.cmsproektnaapi.persistence;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String title;

    @Lob
    @Column(nullable = false)
    public String content;

    @Column(nullable = false)
    public String category;

    @Column(nullable = false)
    // @JsonSerialize(using=)
    //    public LocalDateTime date;
    public String date;

    @Column
    public String imageFileName;

    @Column
    public String tags;

    public Post() {

    }

    public Post(String title, String content, String category, String date, String imageFileName, String tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.imageFileName = imageFileName;
        this.tags = tags;
    }
}
