package com.zf.dao;

import com.zf.bean.student;

import java.util.List;

public interface studentDao {
    public void insert(student s);
    public void update(student s);
    public void delete(Integer id);
    public student findByID(Integer id);
    public List<student> findAll();
}
