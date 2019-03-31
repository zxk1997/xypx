package com.zxk1997.px.common.models;

public class PxTag {
    private Integer id;

    private String name;

    private Integer i;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

	@Override
	public String toString() {
		return "PxTag [id=" + id + ", name=" + name + ", i=" + i + "]";
	}
}