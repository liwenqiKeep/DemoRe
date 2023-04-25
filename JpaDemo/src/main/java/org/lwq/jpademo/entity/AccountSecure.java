package org.lwq.jpademo.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * @author liwenqi
 */
@Data
@Entity
@Table(name = "account_secure")
public class AccountSecure {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    @Id
    int id;

    @Column(name = "slot")
    String slot;

    @Override
    public String toString() {
        return "AccountSecure{" +
                "id=" + id +
                ", slot='" + slot + '\'' +
                '}';
    }
}
