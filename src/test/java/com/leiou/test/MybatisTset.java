package com.leiou.test;

import com.leiou.mapper.BrandMapper;
import com.leiou.pojo.Brand;
import com.leiou.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTset {


    @Test
    public void testSelectAll() throws IOException {
        //todo 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //todo 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //todo 获取Mapper接口的代理对象
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);
        //todo 执行方法
        List<Brand> brands = brandmapper.selectAll();
        System.out.println(brands);
        System.out.println("查询成功");

        //todo 释放
        sqlSession.close();


    }

    @Test
    public void testSelectById() throws IOException {
        //todo 接收参数
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        System.out.println("查询成功");

        sqlSession.close();


    }

    @Test
    public void testSelectByCondition() throws IOException {
        //todo 接收参数
        int status = 1;
        String companyName = "小米";
        String brandName = "小米";
        companyName = "%"+ companyName+"%";
        brandName = "%" + brandName + "%";


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(status,companyName,brandName);
        System.out.println(brands);
        System.out.println("模糊查询成功");

        sqlSession.close();

    }

    @Test
    public void testselectZhengjia() throws IOException {
        //todo 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //todo 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //todo 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //todo 执行方法

        String aodi = mapper.selectZhengjia(new Brand(4, "奥迪", "奥迪集团", 5, "奥迪牛逼", 1));
        System.out.println(aodi);
        System.out.println("插入成功");

        //todo 释放
        sqlSession.close();

    }
    @Test
public void  testselectShanchu() throws IOException {
    //todo 获取sqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //todo 获取sqlsession对象
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //todo 获取Mapper接口的代理对象
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    //todo 执行方法
    mapper.selectShanchu(5);
    System.out.println("删除成功");

    //todo 释放
        sqlSession.close();
    }

    @Test
    public void  testselectGai() throws IOException {
        //todo 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //todo 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //todo 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //todo 执行方法
        String aodi = mapper.selectGai(new Brand(3, "小米科技", "小米集团", 6, "碉堡了", 1));
        System.out.println();
        System.out.println("修改成功");

        //todo 释放
        sqlSession.close();
    }


}
