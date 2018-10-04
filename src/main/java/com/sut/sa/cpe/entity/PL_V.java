package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name="PL_V")
public class PL_V {
    @Id
    
    @SequenceGenerator(name="plv_seq",sequenceName="plv_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="plv_seq")  
    @Column(name="PLV_ID",unique = true, nullable = true)
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Video.class)
    @JoinColumn(name = "VS_ID", insertable = true)
    private  Video video;

    @Column(name="Playlist_ID")
    private Long playlistId;

}