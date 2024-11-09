package com.project.kinhdichapp.repositories;

import com.project.kinhdichapp.models.Que;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueRepository extends JpaRepository<Que, Long> {

    // find all
    List<Que> findAll();
}
