package in.andra.today_news.EntityClasses;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;   

    @Column(name = "news_id")
    private Long newsId;     

    @Column(name = "user_id")
    private Long userId;     

    @Column(name = "comment_text")
    private String commentText; 

    @Column(name = "created_at")
    private LocalDateTime createdAt; 
}
