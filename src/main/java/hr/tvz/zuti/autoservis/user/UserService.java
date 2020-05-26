package hr.tvz.zuti.autoservis.user;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByUsername(String username);
}