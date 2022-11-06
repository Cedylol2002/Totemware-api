package com.totemware.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("News")
@Getter
@Setter

public class NewsModel {
    @Id
    private String id;
    private String newsTitle;
    private String newsBodyMessage;
    private String newsRegardingMessage;
}
