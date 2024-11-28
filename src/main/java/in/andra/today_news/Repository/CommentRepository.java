package in.andra.today_news.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.andra.today_news.EntityClasses.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    @Query("SELECT c FROM Comment c WHERE c.newsId = :newsId")
    List<Comment> findByNewsId(Long newsId);


}
