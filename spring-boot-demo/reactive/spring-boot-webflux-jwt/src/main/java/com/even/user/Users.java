package com.even.user;

import com.even.auth.model.Account;
import com.even.auth.model.UserRole;
import com.even.auth.model.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:18
 * @describe
 */

@Getter
@Builder
@NoArgsConstructor
public class Users extends Account {

    public Users(String userId, String password, String email, UserStatus state,
                 List<UserRole> roles, String refreshToken) {
        super(userId, password, email, state, roles, refreshToken);
    }

    public Users(String userId, String password, String email) {
        super(userId, password, email, UserStatus.NORMAL, Collections.singletonList(UserRole.ROLE_USER), null);
    }
}
