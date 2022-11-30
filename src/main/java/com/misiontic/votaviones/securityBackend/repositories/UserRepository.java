package com.misiontic.votaviones.securityBackend.repositories;

import com.misiontic.votaviones.securityBackend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    Optional <User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
    @Query(value = "SELECT * FROM user WHERE email=? AND password=?;", nativeQuery = true)
    Optional <User> login(String email, String password);
}
