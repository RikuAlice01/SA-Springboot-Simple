package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.PL_V;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PL_VRepository extends JpaRepository<PL_V, Long> {

}