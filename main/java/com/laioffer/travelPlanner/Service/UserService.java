package com.laioffer.travelPlanner.Service;

import com.laioffer.travelPlanner.dao.UserDao;
import com.laioffer.travelPlanner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser (User user) {
        userDao.addUser(user);
    }
}
