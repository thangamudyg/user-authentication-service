package com.user.repository;

import com.user.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Thangamudy Gurusamy
 * Date : 15/04/24
 * Package : com.user.repository
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    @Query(value="select u from UserDetails u where u.loginId=?1")
    public UserDetails findByLoginId(String loginId);

}
