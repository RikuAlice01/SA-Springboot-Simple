package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.entity.PL_V;
import com.sut.sa.cpe.entity.Video;
import com.sut.sa.cpe.repository.PL_VRepository;
import com.sut.sa.cpe.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class PL_VController {
    @Autowired  private final PL_VRepository      pl_vRepository;
    @Autowired  private       VideoRepository     videoRepository;

@Autowired
PL_VController(PL_VRepository pl_vRepository) {
        this.pl_vRepository = pl_vRepository;
    }


    @PostMapping("/Commenting/{idPlaylist}/{code}")
    public PL_V newVideoAt(@PathVariable Long idPlaylist,@PathVariable String code) {
        PL_V newPL_V = new PL_V();
        Video video = videoRepository.findByCode(code);
        
        newPL_V.setVideo(video);
        newPL_V.setPlaylistId(idPlaylist);
       return pl_vRepository.save(newPL_V);                               //บันทึก Objcet ชื่อ comment
    }

    
    
}
