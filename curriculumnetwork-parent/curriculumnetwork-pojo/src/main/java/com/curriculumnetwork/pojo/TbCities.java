package com.curriculumnetwork.pojo;

/**
 * @author zhangyu
 * pojo
 */
public class TbCities {
    /**
     * id
     */
    private Integer id;
    /**
     * 城市id
     */
    private String cityid;
    /**
     * 城市
     */
    private String city;
    /**
     *  省id
     */
    private String provinceid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }
}