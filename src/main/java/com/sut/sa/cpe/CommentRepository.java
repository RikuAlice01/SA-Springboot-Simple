package com.sut.sa.cpe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CommentRepository extends JpaRepository<Comment, Long> {
}