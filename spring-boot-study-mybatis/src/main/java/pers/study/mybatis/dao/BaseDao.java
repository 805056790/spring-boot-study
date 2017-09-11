package pers.study.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author : panxin
 */
public class BaseDao<T> {

    @Autowired
    protected SqlSession sqlSession;

    public T findById(Long id) {
        return sqlSession.selectOne("findById", id);
    }

    public List<T> findAll(Long id) {
        return sqlSession.selectList("findAll");
    }

    public int create(T t) {
        return sqlSession.insert("create", t);
    }

    public int creates(List<T> dataList) {
        return sqlSession.insert("creates", dataList);
    }

    public int update(T t) {
        return sqlSession.update("update", t);
    }

    public int delete(Long id) {
        return sqlSession.delete("delete", id);
    }

    public void paging(Map<String, Object> criteria) {
        // TODO paging
    }

}
