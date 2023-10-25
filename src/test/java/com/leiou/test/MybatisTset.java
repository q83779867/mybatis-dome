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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTset {


    public MybatisTset() throws IOException {
    }

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

        Map map = new HashMap();
        //map.put("status" , status);
        map.put("companyName", companyName);
      //  map.put("brandName" , brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(map);
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

        String aodi = mapper.selectZhengjia(new Brand(5, "奥迪", "奥迪集团", 5, "奥迪牛逼", 1));
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
    mapper.selectShanchu(43);
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


    @Test
    public void testSelectByConditionSingle() throws IOException {
        //todo 接收参数
        int status = 1;
        String companyName = "小米";
        String brandName = "小米";
        companyName = "%"+ companyName+"%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
      //  brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        System.out.println("模糊查询成功");

        sqlSession.close();

    }

    @Test
    public void add() throws IOException {
        //todo 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        int id = brand.getId();
        System.out.println(brand.getId());
        System.out.println("添加成功");
        System.out.println(mapper);
        System.out.println("添加成功");

       // sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void add1() throws IOException {
        //todo 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);
        int id = brand.getId();
        System.out.println(brand.getId());
        System.out.println("添加成功");
        System.out.println(mapper);
        System.out.println("添加成功");

        sqlSession.close();

    }

    @Test
    public void testUpdate() throws IOException {
        //todo 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的大垃圾";
        int ordered = 200;
        int id = 50;

        Brand brand = new Brand();
       brand.setStatus(status);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        brand.setDescription(description);
        //brand.setOrdered(ordered);
        brand.setId(id);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int updates = mapper.update(brand);
        System.out.println(updates);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //todo 接收参数

        int id = 46;



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

    mapper.deleteById(id);
       // System.out.println(updates);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //todo 接收参数

        int[] ids = {47,48,49};



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);
        // System.out.println(updates);
        sqlSession.commit();
        sqlSession.close();
    }
}

