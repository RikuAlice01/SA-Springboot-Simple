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
            VideoRepository videoRepository, PlaylistRepository playlistRepository,PL_VRepository pl_vRepository) {
        return args -> {
            Stream.of("Tanapon", "Sitthichai", "Somchai", "Nanti").forEach(userName -> { // Stream "ชื่อ" ผ่านตัวแปร
                                                                                         // name
                // โดยวนลูปตามจำนวนข้อมูล
                User user = new User();
                user.setUsername(userName); // set userName บน Object ชื่อ user
                userRepository.save(user); // บันทึก Objcet ชื่อ user
                // new UserController(userRepository).newUser(userName);

                Video newVideo = new Video(); // สร้าง Object Video
                Video newVideo2 = new Video(); // สร้าง Object Video
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
                    // new VideoController(videoRepository).newVideo(newVideo,userName);

                    code = "r4j6H-f9j8Y";
                    newVideo2.setCode(code); // set code บน Object ชื่อ video
                    newVideo2.setUrl("https://www.youtube.com/watch?v=" + code); // set code บน Object ชื่อ video
                    newVideo2.setTitle("【LYRIC VIDEO】Lanla (La La La) by Jan Chan\""); // set code บน Object ชื่อ video
                    newVideo2.setVideoUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ video
                    videoRepository.save(newVideo2); // บันทึก Objcet ชื่อ video
                    // new VideoController(videoRepository).newVideo(newVideo,userName);

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

                } else if (userName == "Nanti") {
                    userUpper = userRepository.findByUsername(userName);
                    code = "dXi2FDWnySU";
                    newVideo.setCode(code); // set code บน Object ชื่อ video
                    newVideo.setUrl("https://www.youtube.com/watch?v=" + code); // set code บน Object ชื่อ video
                    newVideo.setTitle("Can Nayika - กลับมานะ [Official MV]"); // set code บน Object ชื่อ video
                    newVideo.setVideoUser(userUpper); // get User Id เพื่อ set User Id บน Object ชื่อ video
                    videoRepository.save(newVideo); // บันทึก Objcet ชื่อ video
                    // new VideoController(videoRepository).newVideo(video,userName);
                }

            });

            Playlist newPlaylist = new Playlist();
            
                          
            User userPlaylsit = userRepository.findByUsername("Sitthichai"); // สร้าง playlist
            newPlaylist.setName("Sitthichai's Playlist");
            newPlaylist.setAdder(userPlaylsit);
            playlistRepository.save(newPlaylist);

             Playlist playlist = playlistRepository.findById(1); // add video ครั้งที่ 1
             Video addVideo1 = videoRepository.findByCode("dXi2FDWnySU");
             Video addVideo2 = videoRepository.findByCode("r4j6H-f9j8Y");

             PL_V newPL_V1 = new PL_V();
             newPL_V1.setVideo(addVideo1);
             newPL_V1.setPlaylistId((long) 1);
             pl_vRepository.save(newPL_V1);
             playlist.getListVideo().add(newPL_V1);

               PL_V newPL_V2 = new PL_V();
               newPL_V2.setVideo(addVideo2);
               pl_vRepository.save(newPL_V2);
               playlist.getListVideo().add(newPL_V2);
               playlistRepository.save(playlist);

             Playlist playlist2 = playlistRepository.findById(1);
             Video addVideo12 = videoRepository.findByCode("O8etN-2fc1c"); // add video ครั้งที่ 2

             PL_V newPL_V3 = new PL_V();
             newPL_V3.setVideo(addVideo12);
             newPL_V3.setPlaylistId((long)1);
             pl_vRepository.save(newPL_V3);

             playlist2.getListVideo().add(newPL_V3);
             playlistRepository.save(playlist2);


             Playlist newPlaylistA = new Playlist();
             User userPlaylsitA = userRepository.findByUsername("Tanapon"); // สร้าง playlist
             newPlaylistA.setName("Sitthichai's Playlist2");
             newPlaylistA.setAdder(userPlaylsitA);
             playlistRepository.save(newPlaylistA);

            //  Playlist playlistA1 = playlistRepository.findById(2); // add video ครั้งที่ 1
            //  Video addVideoA1 = videoRepository.findByCode("dXi2FDWnySU");
            //  Video addVideoA2 = videoRepository.findByCode("r4j6H-f9j8Y");
            
            //  PL_V newPL_V4 = new PL_V();
            //  newPL_V4.setVideo(addVideoA1);
            //  newPL_V4.setPlaylistId((long)2);
            //  pl_vRepository.save(newPL_V4);
            //  playlistA1.getListVideo().add(newPL_V4);

            //  PL_V newPL_V5 = new PL_V();
            //  newPL_V5.setVideo(addVideoA2);
            //  newPL_V5.setPlaylistId((long)2);
            //  pl_vRepository.save(newPL_V5);
            //  playlistA1.getListVideo().add(newPL_V5);
            //  playlistRepository.save(playlistA1);

            //  Playlist playlistA2 = playlistRepository.findById(2);
            //  Video addVideoA3 = videoRepository.findByCode("O8etN-2fc1c"); // add video ครั้งที่ 2

            //  PL_V newPL_V6 = new PL_V();
            //  newPL_V6.setVideo(addVideoA3);
            //  newPL_V6.setPlaylistId((long)2);
            //  pl_vRepository.save(newPL_V6);
            //  playlistA2.getListVideo().add(newPL_V6);
            //  playlistRepository.save(playlistA2);         

            videoRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity video บน Terminal
            commentRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity comment บน Terminal
            userRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity user บน Terminal
            pl_vRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity playlist บน
            playlistRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity playlist บน
                                                                       // Terminal

        };
    }

}