package com.sut.sa.cpe;

import com.sut.sa.cpe.entity.*;
import com.sut.sa.cpe.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;

@SpringBootApplication
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository, CommentRepository commentRepository,
            VideoRepository videoRepository,PlaylistRepository playlistRepository) {
        return args -> {
            Stream.of("Tanapon", "Sitthichai", "Somchai", "Nanti").forEach(userName -> { // Stream "ชื่อ" ผ่านตัวแปร
                                                                                         // name
                // โดยวนลูปตามจำนวนข้อมูล
                   User user = new User();
                   user.setUsername(userName); // set userName บน Object ชื่อ user
                   userRepository.save(user); // บันทึก Objcet ชื่อ user
              //  new UserController(userRepository).newUser(userName);
              
                Video newVideo = new Video(); // สร้าง Object Video
                Comment comment = new Comment(); // สร้าง Object Comment
                User commentator = new User();
                User userUpper = new User();
                Video commeting = new Video(); // สร้าง Objcet User ชื่อ commentator
                String code; // สร้าง ตัวแปรประเภท String และกำหนดค่า

                if (userName == "Sitthichai") {
                    
                    userUpper = userRepository.findByUsername(userName);
                    code = "O8etN-2fc1c";
                    newVideo.setCode(code); // set code บน Object ชื่อ video
                    newVideo.setUrl("https://www.youtube.com/watch?v=" + code); // set code บน Object ชื่อ video
                    newVideo.setTitle("Tao Kae Noi Presents BNK48 1st Concert \"STARTO\""); // set code บน Object ชื่อ
                    newVideo.setVideoUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ video
                    videoRepository.save(newVideo); // บันทึก Objcet ชื่อ video
                  //     new VideoController(videoRepository).newVideo(newVideo,userName);

                    commentator = userRepository.findByUsername(userName);
                    commeting = videoRepository.findByCode(code);
                    comment.setContent("The first comment."); // set content บน Object ชื่อ comment
                    comment.setCommentedUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ comment
                    comment.setCommentedVideo(commeting); // get Video Id เพื่อ set Video Id บน Object ชื่อ comment
                    commentRepository.save(comment); // บันทึก Objcet ชื่อ comment
                } else if (userName == "Somchai") {
                    code = "O8etN-2fc1c";
                    commentator = userRepository.findByUsername(userName);
                    commeting = videoRepository.findByCode(code);
                    comment.setContent("The second comment."); // set content บน Object ชื่อ comment
                    comment.setCommentedUser(commentator); // get User Id เพื่อ set User Id บน Object ชื่อ comment
                    comment.setCommentedVideo(commeting); // get Video Id เพื่อ set Video Id บน Object ชื่อ comment
                    commentRepository.save(comment); // บันทึก Objcet ชื่อ comment

                    userUpper = userRepository.findByUsername(userName);
                    code = "r4j6H-f9j8Y";
                    newVideo.setCode(code); // set code บน Object ชื่อ video
                    newVideo.setUrl("https://www.youtube.com/watch?v=" + code); // set code บน Object ชื่อ video
                    newVideo.setTitle("【LYRIC VIDEO】Lanla (La La La) by Jan Chan\""); // set code บน Object ชื่อ video
                    newVideo.setVideoUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ video
                    videoRepository.save(newVideo); // บันทึก Objcet ชื่อ video
                 // new VideoController(videoRepository).newVideo(newVideo,userName);
                } else if(userName == "Nanti"){
                    userUpper = userRepository.findByUsername(userName);
                    code = "dXi2FDWnySU";
                    newVideo.setCode(code); // set code บน Object ชื่อ video
                    newVideo.setUrl("https://www.youtube.com/watch?v=" + code); // set code บน Object ชื่อ video
                    newVideo.setTitle("Can Nayika - กลับมานะ [Official MV]"); // set code บน Object ชื่อ video
                    newVideo.setVideoUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ video
                    videoRepository.save(newVideo); // บันทึก Objcet ชื่อ video
                //  new VideoController(videoRepository).newVideo(video,userName);
                }

            });

            Playlist newPlaylist = new Playlist();
            User userPlaylsit = userRepository.findByUsername("Sitthichai");
            newPlaylist.setName("Sitthichai's Playlist");
            newPlaylist.setAdder(userPlaylsit);
            playlistRepository.save(newPlaylist);

            Video addVideo1 = videoRepository.findByCode("dXi2FDWnySU");
            Video addVideo2 = videoRepository.findByCode("r4j6H-f9j8Y");
            newPlaylist.getAddVideo().add(addVideo1);
            newPlaylist.getAddVideo().add(addVideo2);
            playlistRepository.save(newPlaylist);


            videoRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity video บน Terminal
            commentRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity comment บน Terminal
            userRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity user บน Terminal
            playlistRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity playlist บน Terminal
            
        };
    }


}