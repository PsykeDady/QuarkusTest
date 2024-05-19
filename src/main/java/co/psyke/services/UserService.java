package co.psyke.services;

import co.psyke.models.UserEntity;
import co.psyke.models.UserResponse;
import co.psyke.models.mappers.UserMapper;
import co.psyke.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;
 

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public void addUser(UserResponse u) {
        userRepository.addUser(UserMapper.responseToEntity(u));
    }

    public List<UserResponse> listUsers () {
        List<UserEntity> users = userRepository.listAll();

        return users.stream().map(v -> UserMapper.entityToResponse(v)).collect(Collectors.toList());
    }

    public UserResponse getUser(String username) {
        UserEntity user = userRepository.getUser(username); 
        if(user==null) {
            throw new NotFoundException("User "+username+" not found");
        }
        return UserMapper.entityToResponse(user);
    }

    public void updateUser (UserResponse user){
        userRepository.updateUser(UserMapper.responseToEntity(user));
    }

    public void deleteUser (UserResponse user) {
        userRepository.deleteUser(UserMapper.responseToEntity(user));
    }
}
