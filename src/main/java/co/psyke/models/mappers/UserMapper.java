package co.psyke.models.mappers;

import co.psyke.models.UserEntity;
import co.psyke.models.UserResponse;

public final class UserMapper {
    private UserMapper(){}

    public static UserResponse entityToResponse (UserEntity u) {
        return UserResponse.builder()
                    .username(u.getUsername())
                    .email(u.getEmail())
                    .psk(u.getPsk())
                .build();
    }

    public static UserEntity responseToEntity (UserResponse u) {
        return UserEntity.builder()
                    .username(u.getUsername())
                    .email(u.getEmail())
                    .psk(u.getPsk())
                .build();
    }
}
