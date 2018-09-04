package com.sut.sa.cpe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CommentController {
    private CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/Comments")
    public Collection<Comment> Comment() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
    
}
