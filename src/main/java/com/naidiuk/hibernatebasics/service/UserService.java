package com.naidiuk.hibernatebasics.service;

import com.naidiuk.hibernatebasics.entity.Gender;
import com.naidiuk.hibernatebasics.entity.User;
import com.naidiuk.hibernatebasics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void run() {
        User user = createUser();
        userRepository.save(user);
        user.setFirstName("Elon");
        user.setLastName("Mask");
        userRepository.update(user);
        userRepository.findById(1L);
        userRepository.delete(13L);
        userRepository.getAll().forEach(System.out::println);
    }

    private User createUser() {
        User user = new User();
        user.setFirstName("Tony");
        user.setLastName("Stark");
        user.setAge(49);
        user.setGender(Gender.MALE);
        return user;
    }
}
