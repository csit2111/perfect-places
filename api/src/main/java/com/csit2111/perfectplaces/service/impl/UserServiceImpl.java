package com.csit2111.perfectplaces.service.impl;

import com.csit2111.perfectplaces.model.User;
import com.csit2111.perfectplaces.repository.UserRepository;
import com.csit2111.perfectplaces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public User getUserById(long id) {
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        List<User> users = userRepository.findAllById(ids);
        if (users.isEmpty())
            return new User();
        return users.get(0);
    }
}
