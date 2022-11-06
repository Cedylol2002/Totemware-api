package com.totemware.api.controller;

import com.totemware.api.model.NewsModel;
import com.totemware.api.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("https://totemware-api.herokuapp.com")
@RequestMapping("totem/api/v1")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public ResponseEntity<List<NewsModel>> getAllNews(){ return newsService.getAllNews();}

    @GetMapping("/news/{id}")
    public ResponseEntity<NewsModel> findOneNews(@PathVariable String id){return newsService.findOneNews(id);}

    @PostMapping("/news")
    public ResponseEntity<NewsModel> addNews(@RequestBody NewsModel newsModel){ return newsService.addNews(newsModel);}

    @PutMapping("/news/{id}")
    public ResponseEntity<NewsModel> updateNews(@PathVariable String id, @RequestBody NewsModel newsModel){return newsService.updateOneNews(id,newsModel);}

    @DeleteMapping("/news/{id}")
    public void deleteOneNews(@PathVariable String id){newsService.deleteOneNews(id);}

    @DeleteMapping("/news/delAll")
    public void deleteAllNews(){newsService.deleteAllNews();}

}
