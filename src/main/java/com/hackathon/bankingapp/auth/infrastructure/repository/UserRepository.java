package com.hackathon.bankingapp.auth.infrastructure.repository;

import com.hackathon.bankingapp.auth.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class UserRepository {

     public static final Map<String, User> userDatabase = new HashMap<>();

     public void saveUser(User user) {
         userDatabase.put(user.getEmail(), user);
     }
     public boolean emailOrPhoneExists(User user) {
         return userDatabase.containsKey(user.getEmail()) || userDatabase.values().stream()
                 .anyMatch(u -> u.getPhoneNumber().equals(user.getPhoneNumber()));
     }
     public boolean emailExists(String email) {
         return userDatabase.containsKey(email);
     }

     ///* Antes de ser llamado se debe comprobar que el correo existe en el userDatabase
     public boolean passwordMatchesEmail(String email, String password) {
         return userDatabase.get(email).getPassword().equals(password);
     }

     public void logInUser(String email) {
         User user = userDatabase.get(email);
         user.setLogged(true);
     }

     public User getUser(String email) {
         return userDatabase.get(email);
     }
}
