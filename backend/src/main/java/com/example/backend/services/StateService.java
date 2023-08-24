package com.example.backend.services;

import com.example.backend.models.StateModel;
import com.example.backend.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository state;

    //Show list of states
    public List<StateModel> listStates(){
        return state.findAll();
    }

    //Get State by id
    public Optional<StateModel> getStateById(Integer id){
        return state.findById(id);
    }

    //Create state
    public StateModel saveState(StateModel s){
        return state.save(s);
    }

    //Update state by id
    public StateModel updateState(Integer id, StateModel request){
        StateModel s = state.findById(id).get();

        if(s != null){
            s.setState(request.getState());
            return state.save(s);
        }

        return null;
    }

    //Delete state by id
    public void deleteState(Integer id){
        state.deleteById(id);
    }
}
