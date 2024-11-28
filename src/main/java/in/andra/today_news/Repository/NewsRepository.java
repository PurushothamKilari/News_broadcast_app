package in.andra.today_news.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.andra.today_news.EntityClasses.News;

public interface NewsRepository extends JpaRepository<News,Long> {
    // @Override
    // public News save(News news) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'save'");
    // }

}
