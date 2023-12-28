package com.rich.onlinegamesshop.service.modelService.impl;

import com.rich.onlinegamesshop.model.Publisher;
import com.rich.onlinegamesshop.repository.PublisherRepository;
import com.rich.onlinegamesshop.service.modelService.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
