package com.zf.daoIMP;

import com.zf.bean.student;
import com.zf.connection.DataBaseConnection;
import com.zf.dao.studentDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class studentDAOIMP  implements studentDao {
    @Override
    public void insert(student s) {
         String sql="insert into student(id,name) values(?,?)";
         //  String sql="insert into student(id,name) values(null,?)";  （测试主键自增）
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,s.getId());  //如果测试主键自增这句代码不需要
            pstmt.setString(2,s.getName()); //如果测试主键自增这句代码parameterIndex 改为1

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }

    @Override
    public void update(student s) {
        String sql="update student set name=? where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);

            pstmt.setString(1,s.getName());
            pstmt.setInt(2,s.getId());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql="delete  from student where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public student findByID(Integer id) {
        String sql="select * from student where id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        student res=new student();
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                Integer id1 = set.getInt(1);
                String name = set.getString(2);
                System.out.println("id:" + set.getInt(1) + " name:" + set.getString(2));
                res.setId(id1);
                res.setName(name);
            }
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<student> findAll() {
        String sql="select * from student ";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        List<student> list=new ArrayList<>();
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet set = pstmt.executeQuery();
            while (set.next()) {
                Integer id1 = set.getInt(1);
                String name = set.getString(2);
                student student = new student(id1, name);
                list.add(student);
            }
            pstmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
