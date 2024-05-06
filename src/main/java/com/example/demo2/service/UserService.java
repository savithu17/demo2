package com.example.demo2.service;

import com.example.demo2.entity.Organization;
import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> updateUser(Long id, User userDetails){
        return userRepository.findById(id).map(existingUser ->{
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setAge(userDetails.getAge());
            existingUser.setCompany(userDetails.getCompany());
            existingUser.setId(userDetails.getId());
            return userRepository.save(existingUser);
        });
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
