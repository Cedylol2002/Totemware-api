package com.totemware.api.service;

import com.totemware.api.model.NewsModel;
import com.totemware.api.repository.NewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }
    public ResponseEntity<List<NewsModel>> getAllNews(){
        return new ResponseEntity<List<NewsModel>>(newsRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<NewsModel> findOneNews(String id){
        return new ResponseEntity<NewsModel>(newsRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<NewsModel> updateOneNews(String id, NewsModel newsModel){
        NewsModel newNews = newsRepository.findById(id).get();
        newsModel.setId(newNews.getId());
        newNews = newsModel;
        if(id != null){
            return new ResponseEntity<NewsModel>(newsRepository.save(newNews), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<NewsModel>(HttpStatus.NOT_FOUND);
        }
    }
    public void deleteOneNews(String id){newsRepository.deleteById(id);}

    public void deleteAllNews(){newsRepository.deleteAll();}

    public ResponseEntity<NewsModel> addNews(NewsModel newsModel){
        return new ResponseEntity<NewsModel>(newsRepository.save(newsModel), HttpStatus.CREATED);
    }

}
