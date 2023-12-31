package com.rich.onlinegamesshop.service.modelService;

import com.rich.onlinegamesshop.model.Publisher;

import java.util.List;

public interface PublisherService {
    void addPublisher(Publisher publisher);
    List<Publisher> getAllPublishers();
}
