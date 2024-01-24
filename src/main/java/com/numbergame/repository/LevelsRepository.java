package com.numbergame.repository;

import com.numbergame.entity.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelsRepository extends JpaRepository<Levels, Integer> {
    Levels findByLevelNumber(Long levelNumber);
}
