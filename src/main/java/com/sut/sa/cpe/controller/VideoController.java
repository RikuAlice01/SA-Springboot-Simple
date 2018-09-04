package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.Video;
import com.sut.sa.cpe.repository.VideoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class VideoController {
    private VideoRepository repository;

    public VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/Videos")
    public Collection<Video> Video() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}


