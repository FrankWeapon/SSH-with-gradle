package org.fw.dao;

import org.fw.util.ReflectUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by frank-weapon on 15-3-20.
 */
public abstract class BaseDao<T,PK extends Serializable> {


    private Class<?> entityClass;
    public BaseDao(){
        //new出一个子类对象，父类中的this是子类中的this
        entityClass = ReflectUtil.getGenericParameterType(this.getClass());
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    public void saveOrUpdate(T t){
        getSession().saveOrUpdate(t);
    }

    public void delete(T t){
        getSession().delete(t);
    }

    @SuppressWarnings("unchecked")
    public T findById(PK pk){
        return (T) getSession().get(entityClass, pk);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(){
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByPage(int start, int count){
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setFirstResult(start);
        criteria.setMaxResults(count);
        return criteria.list();
    }

    public Criteria getCriteria(){
        return getSession().createCriteria(entityClass);
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //set
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}

