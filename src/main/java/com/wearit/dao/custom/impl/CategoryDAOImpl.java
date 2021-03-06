/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wearit.dao.custom.impl;

import com.wearit.dao.custom.CategoryDAO;
import com.wearit.model.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ABC
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(Category t) throws Exception {
        Serializable save = sessionFactory.getCurrentSession().save(t);
        return (save != null);
    }

    @Override
    public boolean update(Category t) throws Exception {
        sessionFactory.getCurrentSession().update(t);
        return true;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        Category search = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
        if (search != null) {
            sessionFactory.getCurrentSession().delete(search);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Category search(Integer id) throws Exception {
        return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    }

    @Override
    public List<Category> getAll() throws Exception {
        List<Category> categorys = sessionFactory.getCurrentSession().createCriteria(Category.class).list();
        return categorys;
    }

    @Override
    public Category getCategoryByName(String name) throws Exception {
        Criteria c2 = sessionFactory.getCurrentSession().createCriteria(Category.class);
        c2.add(Restrictions.eq("name", name));
        c2.setMaxResults(1);
        Category category = (Category) c2.uniqueResult();
        return category;
    }
}
