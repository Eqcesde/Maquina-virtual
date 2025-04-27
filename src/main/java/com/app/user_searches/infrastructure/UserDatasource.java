package com.app.user_searches.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.users.domain.IUserRepository;
import com.app.users.domain.Users;

@Component
public class UserDatasource {

    private final IUserRepository userRepository;

    public UserDatasource(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> update(Users user, Long id) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        });
    }

    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
