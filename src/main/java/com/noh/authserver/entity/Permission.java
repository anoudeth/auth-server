package com.noh.authserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PERMISSION")
public class Permission extends BaseIdEntity {

	private String name;

}
