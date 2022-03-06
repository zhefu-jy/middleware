package com.zf;

import com.zf.bean.student;
import com.zf.daoIMP.studentDAOIMP;
import org.junit.Test;

import java.util.List;


public class test {

    /**
     * 测试插入功能
     */
    @Test
    public void test1(){
        studentDAOIMP daoimp = new studentDAOIMP();
        student student = new student( 2,"测试");
        /*
        创建数据库是设置主键自增
        student student = new student( "测试主键自增");
        */
        daoimp.insert(student);
    }

    /**
     * 测试update
     */
    @Test
    public void test2(){
        studentDAOIMP daoimp = new studentDAOIMP();
        student student = new student(2, "测试update");
        daoimp.update(student);
    }

    /**
     * 测试删除
     */

    @Test
    public void test3(){
        studentDAOIMP daoimp = new studentDAOIMP();
        daoimp.delete(2);

    }

    /**
     * 测试根据id查询
     */

    @Test
    public void test4(){
        studentDAOIMP daoimp = new studentDAOIMP();
        student byID = daoimp.findByID(1);
        System.out.println(byID);
    }

    /**
     * 测试查询全部
     */
    @Test
    public void test5(){
        studentDAOIMP daoimp = new studentDAOIMP();
        List<student> all = daoimp.findAll();
        all.stream().forEach(student -> {
            System.out.println(student);
        });
    }
}
