package com.sut.sa.cpe;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository userrepository,CommentRepository commentrepository,VideoRepository videorepository) {
        return args -> {
            Stream.of("Tanapon","Sitthichai","Somchai").forEach(name -> {
                User user = new User();
                Video video = new Video();
                Comment comment = new Comment();
                String code = new String();
                code = "O8etN-2fc1c";
                user.setName(name);
                userrepository.save(user);

                if (name == "Sitthichai") {
                    video.setCode(code);
                    video.setUrl("https://www.youtube.com/watch?v=" + code);
                    video.setTitle("Tao Kae Noi Presents BNK48 1st Concert \"STARTO\"");
                    video.setUserID(user.getUserID(name));
                    videorepository.save(video);
                    
                    videorepository.findAll().forEach(System.out::println);

                    comment.setContent("The first comment.");
                    comment.setUserID(user.getUserID(name));
                    comment.setVideoID(video.getVideoID(code));
                    commentrepository.save(comment);
                    
                    commentrepository.findAll().forEach(System.out::println);
                }
                
            });
            userrepository.findAll().forEach(System.out::println);
        };
    }

}