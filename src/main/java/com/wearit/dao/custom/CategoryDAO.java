/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wearit.dao.custom;

import com.wearit.dao.SuperDAO;
import com.wearit.model.Category;


public interface CategoryDAO extends SuperDAO<Category>{
    public Category getCategoryByName(String name)throws Exception;
}
