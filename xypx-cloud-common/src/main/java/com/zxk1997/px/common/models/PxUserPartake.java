package com.zxk1997.px.common.models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Length;

import com.zxk1997.px.common.interfaces.OpType;

public class PxUserPartake {
	
	@Null
    private Integer id;

	@Length(min=32,max=32,groups= {Default.class,OpType.D.class})
    private String uid;

	@Length(min=32,max=32,groups= {Default.class,OpType.D.class})
    private String aid;

	@Length(min=11,max=11)
    private String phone;

	@Email
    private String email;

	@NotNull
    private Integer at;

	@NotNull
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAt() {
        return at;
    }

    public void setAt(Integer at) {
        this.at = at;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}