package com.kuang.dao;

import com.kuang.entity.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther:ljt
 * @Date: 2021/8/16 - 08 -16 - 15:44
 * @version: 1.0
 */
@Mapper  //@Mapper注解是将mapper文件的dao交给spring管理，执行方法就是执行方法上面的sql语句
public interface NodeMapper {
    //按照id进行查询,只是查询context字段，id是前面调用方法给的值
    @Select("select content from flume4mysql where id = #{id}")
    String findById(Integer id);
}

