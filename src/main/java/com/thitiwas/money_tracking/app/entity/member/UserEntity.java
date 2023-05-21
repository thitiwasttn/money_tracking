package com.thitiwas.money_tracking.app.entity.member;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    @ToString.Exclude
    private String password;

    @Column(name = "FACEBOOK_ID")
    @ToString.Exclude
    private String facebookId;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "updateDate")
    private Date updateDate;
}
