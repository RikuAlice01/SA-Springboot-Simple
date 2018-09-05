package com.sut.sa.cpe;


import com.sut.sa.cpe.entity.*;
import com.sut.sa.cpe.repository.*;

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
            Stream.of("Tanapon","Sitthichai","Somchai").forEach(name -> {       //Stream "ชื่อ" ผ่านตัวแปร name โดยวนลูปตามจำนวนข้อมูล
                User user = new User();                                         //สร้าง Objcet User
                Video video = new Video();                                      //สร้าง Object Video
                Comment comment = new Comment();                                //สร้าง Object Comment
                String code = "O8etN-2fc1c";                                    //สร้าง ตัวแปรประเภท String และกำหนดค่า
                user.setName(name);                                             //set name บน Object ชื่อ user
                userrepository.save(user);                                      //บันทึก Objcet ชื่อ user

                if (name == "Sitthichai") {
                    video.setCode(code);                                        //set code บน Object ชื่อ video
                    video.setUrl("https://www.youtube.com/watch?v=" + code);    //set code บน Object ชื่อ video
                    video.setTitle("Tao Kae Noi Presents BNK48 1st Concert \"STARTO\""); //set code บน Object ชื่อ video
                    video.setUserID(user.getUserID(name));                      //get User Id เพื่อ set User Id บน Object ชื่อ video
                    videorepository.save(video);                                //บันทึก Objcet ชื่อ video
                    videorepository.findAll().forEach(System.out::println);     // แสดง ข้อมูลทั้งหมดใน Entity video บน Terminal

                    comment.setContent("The first comment.");                   //set content บน Object ชื่อ comment
                    comment.setUserID(user.getUserID(name));                    //get User Id เพื่อ set User Id บน Object ชื่อ comment
                    comment.setVideoID(video.getVideoID(code));                 //get Video Id เพื่อ set Video Id บน Object ชื่อ comment
                    commentrepository.save(comment);                            //บันทึก Objcet ชื่อ comment
                    
                    commentrepository.findAll().forEach(System.out::println);   // แสดง ข้อมูลทั้งหมดใน Entity comment บน Terminal
                }
                
            });
            userrepository.findAll().forEach(System.out::println);  // แสดง ข้อมูลทั้งหมดใน Entity user บน Terminal
        };
    }

}