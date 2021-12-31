package com.curriculumnetwork.pojo;

import java.io.Serializable;

/**
 * @author zhangyu
 * pojo
 */
public class TbBrand implements Serializable {
    /**
     * 品牌id
     */
    private Long id;

    /**
     * 品牌名
     */
    private String name;

    /**
     * 第一个字符
     */
    private String firstChar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar == null ? null : firstChar.trim();
    }
}