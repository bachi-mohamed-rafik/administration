package com.banking.admin_module.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Permission {

    @Id
    private String id;

    // ManyToOne → Group
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @JsonIgnoreProperties("permissions")
    private Group group;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "is_read")
    private Boolean isRead;

    @Column(name = "is_write")
    private Boolean isWrite;

    @Column(name = "is_authorize")
    private Boolean isAuthorize;

    @Column(name = "is_parent_with_children")
    private Boolean isParentWithChildren;
}