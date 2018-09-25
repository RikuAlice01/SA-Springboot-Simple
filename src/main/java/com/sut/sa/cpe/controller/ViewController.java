package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.User;
import com.sut.sa.cpe.entity.Video;
import com.sut.sa.cpe.entity.View;
import com.sut.sa.cpe.repository.UserRepository;
import com.sut.sa.cpe.repository.VideoRepository;
import com.sut.sa.cpe.repository.ViewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class ViewController {
    @Autowired   private final ViewRepository    viewRepository;
    @Autowired   private       VideoRepository   videoRepository;
    @Autowired   private       UserRepository    userRepository;

    ViewController(ViewRepository repository) {
        this.viewRepository = repository;
    }


    @GetMapping("/Views/{VideoId}")
    public Collection<View> Views(@PathVariable Long VideoId) {

        return viewRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PostMapping("/Views/{username}/{videoCode}")
    public View newView(View newView,@PathVariable String userName,@PathVariable String videoCode) {   
                 
        User     watchingUser = userRepository.findByUsername(userName);
        Video    watchedVideo = videoRepository.findByCode(videoCode);

        newView.setWatchedVideo(watchedVideo);
        newView.setWatchingUser(watchingUser);
        newView.setWatchedDate(new Date());
        newView.setWatchedTime(new Timestamp(System.currentTimeMillis()));

        return viewRepository.save(newView);                        //บันทึก Objcet ชื่อ view
    }
}