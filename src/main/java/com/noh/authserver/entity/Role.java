package com.noh.authserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Data
@Entity
@Table(name = "ROLE")
public class Role extends BaseIdEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_role",
            joinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_ROLE_PERMROLE"))},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PERMISSION_PERMROLE"))}
    )
    private List<Permission> permissions;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<Permission> permissions) {
//        this.permissions = permissions;
//    }

}