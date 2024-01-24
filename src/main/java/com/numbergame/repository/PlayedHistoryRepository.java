package com.numbergame.repository;

import com.numbergame.entity.PlayedHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayedHistoryRepository extends JpaRepository<PlayedHistory, Long> {
}
