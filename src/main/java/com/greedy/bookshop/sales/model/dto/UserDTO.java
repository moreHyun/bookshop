package com.greedy.bookshop.sales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{
    private long userCode;
    private String userId;
    private String userPwd;
    private String name;
    private String userNo;
    private String phone;
    private Date createUserDate;
    private Date deleteUserDate;
    private String userStatus;
    private long userRoleCode;
    private long userRatingCode;

}
