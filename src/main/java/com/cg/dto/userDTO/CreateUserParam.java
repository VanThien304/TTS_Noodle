package com.cg.dto.userDTO;


import com.cg.repositories.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CreateUserParam {

    private Long roleId;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private UserStatus status;

    private String avatarUrl;

    private String username;

    private String password;


 }

