package com.banking.admin_module.service;

import com.banking.admin_module.model.entity.AppUser;
import com.banking.admin_module.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers() {
        log.info("Fetching all users");
        return appUserRepository.findAll();
    }

    public AppUser getUserById(String id) {
        log.info("Fetching user with id: {}", id);
        return appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public AppUser getUserByLoginName(String loginName) {
        return appUserRepository.findByLoginName(loginName)
                .orElseThrow(() -> new RuntimeException("User not found with loginName: " + loginName));
    }

    public List<AppUser> getActiveUsers() {
        log.info("Fetching active users");
        return appUserRepository.findByIsActiveFlag("1");
    }

    public AppUser createUser(AppUser user) {
        user.setCreatedTime(LocalDateTime.now());
        user.setModifiedTime(LocalDateTime.now());
        log.info("Creating user with loginName: {}", user.getLoginName());
        return appUserRepository.save(user);
    }

    public AppUser updateUser(String id, AppUser details) {
        AppUser user = getUserById(id);

        user.setLoginName(details.getLoginName());
        user.setFirstName(details.getFirstName());
        user.setLastName(details.getLastName());
        user.setBank(details.getBank());
        user.setBranch(details.getBranch());
        user.setBlockStatus(details.getBlockStatus());
        user.setIsOverrideChecker(details.getIsOverrideChecker());
        user.setFirstTimeLoginFlag(details.getFirstTimeLoginFlag());
        user.setIsActiveFlag(details.getIsActiveFlag());
        user.setIsLoggedIn(details.getIsLoggedIn());
        user.setFirstNameLocal(details.getFirstNameLocal());
        user.setLastNameLocal(details.getLastNameLocal());
        user.setUserName(details.getUserName());

        if (details.getPassword() != null) {
            user.setPassword(details.getPassword());
        }

        user.setSoftDelFlag(details.getSoftDelFlag());
        user.setCountAttempts(details.getCountAttempts());
        user.setModifiedTime(LocalDateTime.now());
        log.info("Updating user with id: {}", id);
        return appUserRepository.save(user);
    }

    public void deleteUser(String id) {
        AppUser user = getUserById(id);
        log.info("Deleting user with id: {}", id);
        appUserRepository.delete(user);
    }

    public void softDeleteUser(String id) {
        AppUser user = getUserById(id);
        user.setSoftDelFlag("1");
        user.setModifiedTime(LocalDateTime.now());
        log.info("Soft deleting user with id: {}", id);
        appUserRepository.save(user);
    }
}