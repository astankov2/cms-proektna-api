package mk.ukim.finki.wp.cmsproektnaapi.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime date;

    @Column
    public String imageFileName;

    @Column
    public String tags;

    public Post() {

    }

    public Post(String title, String content, String category, LocalDateTime date, String imageFileName, String tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.imageFileName = imageFileName;
        this.tags = tags;
    }
}
