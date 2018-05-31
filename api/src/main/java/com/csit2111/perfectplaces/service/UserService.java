package com.csit2111.perfectplaces.service;

import com.csit2111.perfectplaces.model.User;

public interface UserService {
    User addUser(User user);
    void deleteUser(long id);
    User editUser(User user);
    User getUserById(long id);
}
