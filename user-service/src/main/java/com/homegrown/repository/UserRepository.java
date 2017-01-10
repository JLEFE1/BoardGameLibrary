package com.homegrown.repository;

import com.homegrown.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by JoLe on 18/12/2016.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

    @RestResource(path = "by-firstName")
    Collection<User> findByFirstName(@Param("firstName") String firstName);

}
