package com.curriculumnetwork.pojo;

/**
 * @author zhangyu
 * pojo
 */
public class TbAreas {
    /**
     * id号码
     */
    private Integer id;

    /**
     * 区域id
     */
    private String areaid;

    /**
     * 区域
     */
    private String area;

    /**
     * 城市id
     */
    private String cityid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }
}