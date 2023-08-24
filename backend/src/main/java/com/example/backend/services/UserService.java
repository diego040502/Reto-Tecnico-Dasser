package com.example.backend.services;

import com.example.backend.models.StateModel;
import com.example.backend.models.UserModel;
import com.example.backend.repositories.StateRepository;
import com.example.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository user;

    @Autowired
    private StateRepository state;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Show list of users
    public List<UserModel> getUsers(){
        return user.findAll();
    }

    //Show list of users with status
    public List<UserModel> getUsersWithStates() {
        return user.findAllWithStates();
    }

    //Get user by id
    public Optional<UserModel> getUserId(Integer id){
        return user.findById(id);
    }

    //Create a user
    public UserModel saveUser(UserModel u){
        String encryptPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptPassword);

        //Asigna el estado de activo al crear el usuario
        StateModel s = state.findFirstState();
        u.setState_id(s);

        u.setCreated(LocalDateTime.now());
        u.setLastUpdate(LocalDateTime.now());
        return user.save(u);
    }

    //Update user by id
    public UserModel updateUser(Integer id, UserModel request){
        UserModel u = user.findById(id).get();

        if(u != null){

            if(!u.getPassword().equals(request.getPassword())){
                String encryptPassword = passwordEncoder.encode(u.getPassword());
                u.setPassword(encryptPassword);
            }
            u.setNombres(request.getNombres());
            u.setApellidos(request.getApellidos());
            u.setLogin(request.getLogin());
            u.setLastUpdate(LocalDateTime.now());
            u.setEmail(request.getEmail());

            return user.save(u);
        }

        return null;
    }

    //Delete user by id
    public void deleteUser(Integer id){
        user.deleteById(id);
    }

    //Get By Name
    public UserModel getUserByName(String nombres){
        return user.getByNombres(nombres);
    }

    //Get by State
    public UserModel getUserByStatus(String state){
        return user.getByEstado(state);
    }

    //Get by Login
    public UserModel getUserByLogin(String login){
        return user.getByLogin(login);
    }


}
