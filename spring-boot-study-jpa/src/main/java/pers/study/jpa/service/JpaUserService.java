package pers.study.jpa.service;

import pers.study.jpa.model.JpaUser;

import java.util.List;

/**
 * @author : panxin
 */
public interface JpaUserService {

    JpaUser findById(Long id);

    List<JpaUser> findAll();

    JpaUser create(JpaUser user);

    Boolean update(Long id, String name);

}
