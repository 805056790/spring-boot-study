package pers.study.jdbc.service;

import pers.study.jdbc.model.JdbcUser;

import java.util.List;

/**
 * @author : panxin
 */
public interface JdbcUserService {

    JdbcUser create(JdbcUser user);

    Boolean update(Long id, String name, String password);

    JdbcUser findById(Long id);

    List<JdbcUser> findAll();

}
