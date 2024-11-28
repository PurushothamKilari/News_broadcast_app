package in.andra.today_news.Services;

import java.util.List;
import java.util.Optional;

import in.andra.today_news.EntityClasses.Comment;

public interface CommentService {

    public Comment saveComment(Comment comment);

    public Optional<Comment> getCommentById(Long commentId);

    public List<Comment> getCommentsByNewsId(Long newsId);

    public void deleteComment(Long commentId);

}
