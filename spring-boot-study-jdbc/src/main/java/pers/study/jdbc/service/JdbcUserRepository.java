package pers.study.jdbc.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pers.study.jdbc.model.JdbcUser;

import javax.transaction.Transactional;


/**
 * @author : panxin
 */
public interface JdbcUserRepository extends CrudRepository<JdbcUser, Long> {

    @Transactional
    @Modifying
    @Query("update JdbcUser user set user.name = ?2, user.password = ?3 where user.id = ?1")
    int update(Long id, String name, String password);

}
