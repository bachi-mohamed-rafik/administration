package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserGroup {

    @Id
    private String id;

    // ManyToOne → AppUser
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("userGroups")
    private AppUser user;

    // ManyToOne → Group
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @JsonIgnoreProperties("userGroups")
    private Group group;

    @Column
    private Boolean persisted;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column
    private String status;  // "1" = Active, "0" = Inactive
}