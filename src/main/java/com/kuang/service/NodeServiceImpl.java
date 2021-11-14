package com.kuang.service;

import com.kuang.dao.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther:ljt
 * @Date: 2021/8/25 - 08 -25 - 11:13
 * @version: 1.0
 */
@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    NodeMapper nodeMapper;
    @Override
    public String getNode(Integer id) {
        //获取指定数据
        String node = nodeMapper.findById(id);

//        //处理node
//        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
//        Matcher matcher = pattern.matcher(node);
//        while(matcher.find())
//        {
//            System.out.println(matcher.group());
//            node = matcher.group();
//        }


        return node;
    }
}
