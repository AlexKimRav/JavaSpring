package com.example.javaspring.Service;

import com.example.javaspring.models.User;
import com.example.javaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRep;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRep = userRepository;
    }

    public List<User> findAll() {
        return userRep.findAll();
    }

    public User save(User user) {
        return userRep.save(user);
    }

    public Optional<User> findById(long id) {
        return userRep.findById(id);
    }

    public void deleteById(Long id) {
        userRep.deleteById(id);
    }
}
