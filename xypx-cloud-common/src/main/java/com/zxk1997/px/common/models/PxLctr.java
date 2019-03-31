package com.zxk1997.px.common.models;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Length;

import com.zxk1997.px.common.interfaces.OpType;

public class PxLctr {
	@NotNull(groups= {Default.class,OpType.U.class})
    private String id;

	@Length(min=5,max=50)
    private String title;
	
	@Length(min=5,max=200)
    private String address;

	@Length(min=11,max=11)
    private String phone;

	@NotNull
    private Date s;

	@NotNull
    private Date e;

	@NotNull
    private Date ps;

	@NotNull
    private Date pe;

	@NotNull
    private String placard;

	@Min(0)
    private Integer plimit;

	@Length(max=100)
    private String summary;

	@NotNull
    private Date time;

    private Integer status;

    private String rm;

    @Length(max=32)
    private String uid;

    @NotNull
    private String content;

    private Integer lb;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getS() {
        return s;
    }

    public void setS(Date s) {
        this.s = s;
    }

    public Date getE() {
        return e;
    }

    public void setE(Date e) {
        this.e = e;
    }

    public Date getPs() {
        return ps;
    }

    public void setPs(Date ps) {
        this.ps = ps;
    }

    public Date getPe() {
        return pe;
    }

    public void setPe(Date pe) {
        this.pe = pe;
    }

    public String getPlacard() {
        return placard;
    }

    public void setPlacard(String placard) {
        this.placard = placard == null ? null : placard.trim();
    }

    public Integer getPlimit() {
        return plimit;
    }

    public void setPlimit(Integer plimit) {
        this.plimit = plimit;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm == null ? null : rm.trim();
    }

    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}