package com.curriculumnetwork.pojo;

import java.io.Serializable;

/**
 * @author zhangyu
 * pojo
 */
public class TbSpecification implements Serializable{
    private Long id;

    private String specName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}