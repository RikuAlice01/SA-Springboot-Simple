package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="video")
public class Video {

    @Id
    @SequenceGenerator(name="video_seq",sequenceName="video_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="video_seq")  
    @Column(name = "VIDEO_ID", unique = true, nullable = false)
    private @NonNull Long id;

    @Column(name="code")
    private @NonNull String code;
    private @NonNull String title;
    private @NonNull String url;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "V_ID", insertable = true)
    private User videoUser;

    @Column(name="Playlist_ID")
    private Long playlsitId;
}
