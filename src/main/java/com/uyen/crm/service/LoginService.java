package com.uyen.crm.service;

import com.uyen.crm.model.Users;
import com.uyen.crm.repository.UsersRepository;

import java.util.List;

public class LoginService {
    UsersRepository usersRepository = new UsersRepository();
    public boolean checkLogin(String email, String password) {
        List<Users> list = usersRepository.getUserByEmailAndPassword(email, password);
        if (list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
