package pers.study.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author : panxin
 */
@SuppressWarnings("unchecked")
public class BaseDao<T> {

    private final String nameSpace;

    @Autowired
    protected SqlSession sqlSession;

    public BaseDao() {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            nameSpace = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]).getSimpleName();
        } else {
            nameSpace = ((Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass())
                    .getActualTypeArguments()[0]).getSimpleName();
        }
    }

    public T findById(Long id) {
        return sqlSession.selectOne(sqlId("findById"), id);
    }

    public List<T> findAll() {
        return sqlSession.selectList(sqlId("findAll"));
    }

    public int create(T t) {
        return sqlSession.insert(sqlId("create"), t);
    }

    public int creates(List<T> dataList) {
        return sqlSession.insert(sqlId("creates"), dataList);
    }

    public int update(T t) {
        return sqlSession.update(sqlId("update"), t);
    }

    public int delete(Long id) {
        return sqlSession.delete(sqlId("delete"), id);
    }

    public void paging(Map<String, Object> criteria) {
        // TODO paging
    }

    /**
     * 需要明确指定 nameSpace
     *
     * @param id 方法名
     * @return mybatis nameSpace
     */
    protected String sqlId(String id){
        return nameSpace + "." + id;
    }

}
