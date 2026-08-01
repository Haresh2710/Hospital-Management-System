package com.hospital.service;

import com.hospital.dao.UserDAO;
import com.hospital.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public boolean login(User user) {

        return userDAO.login(user);

    }

}
