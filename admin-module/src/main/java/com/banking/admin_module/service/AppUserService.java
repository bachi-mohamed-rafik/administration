package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface AppUserService {


    public List<AppUser> getAllUsers();

    public AppUser getUserById(String id);

    public AppUser getUserByLoginName(String loginName);

    public List<AppUser> getActiveUsers();

    public AppUser createUser(AppUser user);

    public AppUser updateUser(String id, AppUser details);

    public void deleteUser(String id);

    public void softDeleteUser(String id) ;
}