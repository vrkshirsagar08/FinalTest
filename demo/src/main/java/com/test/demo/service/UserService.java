package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.entity.User;
import com.test.demo.repository.UserRepository;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String firstName, String middleName, String lastName) {
        String generatedPassword = generatePassword(firstName, middleName, lastName);

        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setPassword(generatedPassword);

        return userRepository.save(user);
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
        String firstTwo = firstName.length() >= 2 ? firstName.substring(0, 2) : firstName;
        String middleTwo = middleName.length() >= 2 ? middleName.substring(0, 2) : middleName;
        String lastTwo = lastName.length() >= 2 ? lastName.substring(0, 2) : lastName;

        Random random = new Random();
        int randomDigits = random.nextInt(900) + 100; 

        return firstTwo + middleTwo + lastTwo + randomDigits;
    }
}
