package com.gmail.morovo1988.projectShop.repositories;

import com.gmail.morovo1988.projectShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findOneByEmailIgnoreCase(String email);

    boolean existsUserByEmail(String email);

//    @Query("SELECT new com.gmail.morovo1988.budjet.dto.requests.UpdateUserReq(u.id, u.name, u.email, u.telephone) FROM User u WHERE u.id = :id")
//    Optional<UpdateUserReq> findUpdateUserReqById(@Param("id") Long id);

    Optional<User> findOneById(Long userId);

    User findUserById(Long id);
}
