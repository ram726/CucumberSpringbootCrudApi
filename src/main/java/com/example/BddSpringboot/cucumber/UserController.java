package com.example.BddSpringboot.cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/fetch/{uId}")
    public User fetchAnUser(@PathVariable Integer uId) throws RecordNotFound {
        return userService.fetchAnUser(uId);
    }
    @PutMapping("/update")
    public User updateStudent(@RequestBody User user) throws RecordNotFound {
        return userService.updateUserDetails(user);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUserById(@PathVariable Integer id) throws RecordNotFound {
        userService.deleteById(id);
        return "User object is deleted with this id: "+id;
    }
}
