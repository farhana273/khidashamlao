package org.farhana273.khidashamlao.repository;

import org.farhana273.khidashamlao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u set u.password = ?2 WHERE u.id = ?1", nativeQuery = true)
    void updatePassword(long id, String password);
}