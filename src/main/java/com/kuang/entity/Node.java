package com.kuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

/**
 * 添加lombok依赖后，会减少Javabean的开发，@Data是默认添加set、get方法，
 *
 * @AllArgsConstructor
 * @NoArgsConstructor 是增加有参和无参的构造
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    Integer id;
    String time;
    String context;
}
