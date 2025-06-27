package com.example.vocaboost.service.topic;

import com.example.vocaboost.model.Topic;
import com.example.vocaboost.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService implements ITopicService {
    @Autowired
    private ITopicRepository topicRepository;

    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    @Override
    public Topic save(Topic entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
