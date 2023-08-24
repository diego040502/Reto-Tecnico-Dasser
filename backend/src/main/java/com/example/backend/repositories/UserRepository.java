package com.example.backend.repositories;

import com.example.backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query("""
            SELECT u FROM UserModel u WHERE u.nombres = :nombres""")
    UserModel getByNombres(String nombres);

    @Query("SELECT u FROM UserModel u JOIN FETCH u.state_id")
    List<UserModel> findAllWithStates();
    @Query("""
            SELECT u FROM UserModel u JOIN u.state_id s where s.state = :state
            """)
    UserModel getByEstado(String state);

    @Query("""
            SELECT u FROM UserModel u where u.login = :login
            """)
    UserModel getByLogin(String login);

}
