package com.leiou.mapper;

import com.leiou.pojo.Brand;
import com.leiou.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     *查询所有
     */

   List<Brand> selectAll();

    /**
     * 查看详情 根据id
     */
    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);

    //List<Brand> selectByCondition(int status,String companyName,String brandName);

    //List<Brand> selectByCondition(Brand brand);
    //List<Brand> selectByCondition(Map map);

    String selectZhengjia(Brand brand);

    String selectShanchu(int id);
    String selectGai(Brand brand);





}
