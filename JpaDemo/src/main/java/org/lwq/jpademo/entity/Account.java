package org.lwq.jpademo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liwenqi
 */
@Data
@Entity
@Table(name = "users")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    @Id
    int uid;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;


}

