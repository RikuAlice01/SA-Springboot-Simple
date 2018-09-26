package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="playList")
public class Playlist {
    @Id
    
    @SequenceGenerator(name="playlist_seq",sequenceName="playlist_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="playlist_seq")  
    @Column(name="Playlist_ID",unique = true, nullable = false)

    private @NonNull Long id;
    private @NonNull String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "AD_ID", insertable = true)
    private  User adder;

        //ref https://en.wikibooks.org/wiki/Java_Persistence/ManyToOne
        //    https://stackoverflow.com/questions/49158025/spring-boot-how-to-save-many-to-one-entities-to-database
        //    ยังมีปัญหาเรื่องเพิ่มวิดีโอในอีก Playlist แล้ววีดีโอใน Playlist เดิมจะหายไป
    
        @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
       // @JoinColumn(name="Playlist_ID", referencedColumnName="Playlist_ID", insertable = true)  
         private Collection<Video> listVideo;
    
}


