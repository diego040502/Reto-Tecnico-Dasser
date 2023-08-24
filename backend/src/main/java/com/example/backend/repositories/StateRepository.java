package com.example.backend.repositories;

import com.example.backend.models.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRepository extends JpaRepository<StateModel, Integer> {
    @Query("SELECT s FROM StateModel s WHERE s.id = (SELECT MIN(id) FROM StateModel)")
    StateModel findFirstState();
}
