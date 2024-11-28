package in.andra.today_news.Services;

import java.util.List;

import in.andra.today_news.EntityClasses.News;

public interface NewsService {
    News createNews(News news);
    News getNewsById(Long id);
    List<News> getAllNews();
    News updateNews(Long id, News news);
    void deleteNews(Long id);
}