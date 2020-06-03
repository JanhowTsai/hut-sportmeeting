package edu.hut.service;

import edu.hut.domain.User;

public interface UserService {

    public User findById(int id);

    User login(String username, String password);
}
