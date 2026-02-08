package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {

    @Id
    private String id;

    @Column(name = "login_name", unique = true, nullable = false)
    private String loginName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // ManyToOne → Bank
    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Bank bank;

    // ManyToOne → Branch
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Branch branch;

    @Column(name = "block_status")
    private String blockStatus;  // "1" = Blocked, "0" = Active

    @Column(name = "is_override_checker")
    private String isOverrideChecker;  // "0" / "1"

    @Column(name = "first_time_login_flag")
    private String firstTimeLoginFlag;  // "0" / "1"

    @Column(name = "is_active_flag")
    private String isActiveFlag;  // "0" / "1"

    @Column(name = "is_logged_in")
    private Integer isLoggedIn;  // 1 / null

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    @Column(name = "first_name_local")
    private String firstNameLocal;

    @Column(name = "last_name_local")
    private String lastNameLocal;

    @Column(name = "user_name")
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;  // Masked in responses

    @Column(name = "soft_del_flag")
    private String softDelFlag;  // "0" / "1"

    @Column(name = "count_attempts")
    private Integer countAttempts;

    // OneToMany → BGMapping (User has many business group mappings)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<BGMapping> bgMappings;

    // OneToMany → UserGroup (User has many user groups)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<UserGroup> userGroups;
}