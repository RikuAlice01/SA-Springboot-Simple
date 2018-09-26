package com.sut.sa.cpe.controller;


import com.sut.sa.cpe.entity.Playlist;
import com.sut.sa.cpe.entity.User;
import com.sut.sa.cpe.entity.Video;

import com.sut.sa.cpe.repository.PlaylistRepository;
import com.sut.sa.cpe.repository.UserRepository;
import com.sut.sa.cpe.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class PlaylistController {

    @Autowired  private final PlaylistRepository playlistRepository;
    @Autowired  private       UserRepository     userRepository;
    @Autowired  private       VideoRepository    videoRepository;
    

    PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }


    @GetMapping("/Playlists")
     public Collection<Playlist> Playlists() {
         return playlistRepository.findAll().stream()
                 .collect(Collectors.toList());
     }

     @PostMapping("/newPlaylsit/{adder}/{namePlaylist}")
     public Playlist newPlaylsit(@PathVariable String namePlaylist,@PathVariable String adder,@PathVariable String code) {

        Playlist newPlaylist = new Playlist();
        User userPlaylsit = userRepository.findByUsername(adder);
        newPlaylist.setAdder(userPlaylsit);
        newPlaylist.setName(namePlaylist);
         return playlistRepository.save(newPlaylist); // บันทึก Objcet ชื่อ Playlist
     }

     
     @PostMapping("/newPlaylsit/{adder}/{namePlaylist}/{listCode}")
     public void addSetVideo(@PathVariable String namePlaylist,@PathVariable String adder,@PathVariable Collection<String> listCode) {
        Playlist Playlist = new Playlist();
            for (String code : listCode) {
                Video addVideo = videoRepository.findByCode(code);
                Playlist.getAddVideo().add(addVideo);
                playlistRepository.save(Playlist); // บันทึก Objcet ชื่อ Playlist
            }
        }
     }