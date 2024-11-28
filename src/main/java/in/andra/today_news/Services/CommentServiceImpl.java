package in.andra.today_news.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.andra.today_news.EntityClasses.Comment;
import in.andra.today_news.Repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    // Create or update a comment
    public Comment saveComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    // Find a comment by its ID
    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    // Get all comments for a specific newsId
    public List<Comment> getCommentsByNewsId(Long newsId) {
        return commentRepository.findByNewsId(newsId);
    }

    // Delete a comment by its ID
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}