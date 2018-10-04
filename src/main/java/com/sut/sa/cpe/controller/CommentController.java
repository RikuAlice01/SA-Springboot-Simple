package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.Comment;
import com.sut.sa.cpe.entity.User;
import com.sut.sa.cpe.entity.Video;
import com.sut.sa.cpe.repository.CommentRepository;
import com.sut.sa.cpe.repository.UserRepository;
import com.sut.sa.cpe.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CommentController {
    @Autowired  private final CommentRepository   commentRepository;
    @Autowired  private       VideoRepository     videoRepository;
    @Autowired  private       UserRepository      userRepository;

@Autowired
     CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/Comments")
    public Collection<Comment> Comment() {
        return commentRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @PutMapping("/Commenting/{userName}/{code}/{CommentText}")
    public Comment newComment(@PathVariable String CommentText,@PathVariable String userName,@PathVariable String code) {
        Comment newComment = new Comment();
        User commentator = userRepository.findByUsername(userName);
        Video commeting = videoRepository.findByCode(code);

        newComment.setContent(CommentText);
        newComment.setCommentedUser(commentator);                         //get User Id เพื่อ set User Id บน Object ชื่อ comment
        newComment.setCommentedVideo(commeting);                          //get Video Id เพื่อ set Video Id บน Object ชื่อ comment

       return commentRepository.save(newComment);                               //บันทึก Objcet ชื่อ comment
    }

    
    
}
