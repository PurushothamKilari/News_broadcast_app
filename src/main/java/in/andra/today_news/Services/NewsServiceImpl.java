package in.andra.today_news.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.andra.today_news.EntityClasses.News;
import in.andra.today_news.Repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {
    
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News createNews(News news) {
        news.setCreatedAt(LocalDateTime.now());
        news.setUpdatedAt(LocalDateTime.now());
        return newsRepository.save(news);
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found with ID: " + id));
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News updateNews(Long id, News news) {
        News existingNews = getNewsById(id);
        existingNews.setTitle(news.getTitle());
        existingNews.setBody(news.getBody());
        existingNews.setImage(news.getImage());
        existingNews.setAuthorId(news.getAuthorId());
        existingNews.setUpdatedAt(LocalDateTime.now());
        return newsRepository.save(existingNews);
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
