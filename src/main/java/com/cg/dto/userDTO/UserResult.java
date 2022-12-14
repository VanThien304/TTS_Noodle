package com.cg.dto.userDTO;

 import com.cg.repositories.model.UserStatus;
 import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

  import java.math.BigDecimal;
 import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserResult {
    private Long id;

    private long roleId;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private UserStatus status;

    private String avatarUrl;

    private String username;

    public UserResult(Long id, long roleId, String fullName, String phone, String email, String address, String avatarUrl) {
        this.id = id;
        this.roleId = roleId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.avatarUrl = avatarUrl;

    }
}
