package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.Playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Playlist findById(long id);
    
}