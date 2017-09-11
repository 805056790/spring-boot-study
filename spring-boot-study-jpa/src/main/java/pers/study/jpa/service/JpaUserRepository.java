package pers.study.jpa.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pers.study.jpa.model.JpaUser;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : panxin
 */
public interface JpaUserRepository extends Repository<JpaUser, Long> {

    JpaUser findById(Long id);

    List<JpaUser> findAll();

    JpaUser save(JpaUser user);

    @SuppressWarnings("JpaQlInspection")
    @Transactional
    @Modifying
    @Query("update JpaUser user set user.name = ?2 where user.id = ?1")
    int update(Long id, String name);

}
