package com.creandoUnaApiRest.repository;

import com.creandoUnaApiRest.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    @Query("Select u From User u WHERE u.name=?1")
    Optional<User> findMyUserByEmail(String email);

    @Query("SELECT u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);

    List<User> findByName (String name);

    //List<User> findByEmailAndName (String name, String email);




    //Using Named Parameters
    @Query("select u from User u where u.name = :name or u.email = :email")
    Optional<User> findByNameOrEmail(@Param("name") String name,
                                     @Param("email") String email);

}
