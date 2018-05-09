package cn.xyz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T> {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Class entityClass;

    public BaseDao(){
        //通过反射获取子类DAO对应的泛型实体类
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        entityClass = (Class)params[0];
    }
}
