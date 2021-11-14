package com.kuang.controller;

import com.kuang.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther:ljt
 * @Date: 2021/8/26 - 08 -26 - 15:46
 * @version: 1.0
 */
@RestController
public class NodeController {
    @Autowired
    NodeService nodeService;


    @RequestMapping(value = "/svg2", method = RequestMethod.POST)
    public String doSvg2(HttpServletRequest request, HttpServletResponse response, Model model) {

        System.out.println("node");
        return "node";
    }
}
