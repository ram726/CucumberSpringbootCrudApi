package com.example.BddSpringboot.cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User fetchAnUser(Integer uId) throws RecordNotFound {
        User user=null;
        Optional<User> userOptional=userRepository.findById(uId);
        if (userOptional.isPresent()){
            user=new User();
            User user1=userOptional.get();

            user.setUId(user1.getUId());
            user.setName(user1.getName());
            user.setAddress(user1.getAddress());
            user.setPhone(user1.getPhone());
            user.setGender(user1.getGender());
        }
        else {
            throw new RecordNotFound("User Record not found.");
        }
        return user;
    }

    public User updateUserDetails(User userInput) throws RecordNotFound {
        Optional<User> userOptional=userRepository.findById(userInput.getUId());
        if(userOptional.isPresent()){
            User user=userOptional.get();
            user.setName(userInput.getName());
            user.setAddress(userInput.getAddress());
            user.setPhone(userInput.getPhone());
            user.setGender(userInput.getGender());
           return  userRepository.save(user);
        }
        else {
            throw new RecordNotFound("User record not present.");
        }
    }

    public void deleteById(Integer id) throws  RecordNotFound {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            userRepository.delete(user);
        }else {
            throw new RecordNotFound("Record not found");
        }
    }
}
