package com.zxk1997.px.common.models;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.zxk1997.px.common.interfaces.OpType;



public class PxUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(groups=OpType.U.class)
	@Null(groups=OpType.C.class)
    private String id;

	@Length(min=6,max=12)
    private String u;

	@Length(min=32,max=32)
    private String p;

	@Length(min=4,max=8,groups=OpType.C.class)
    private String nickname;

	@Null
    private String icon;

    @Null
    private Integer status;

    @Null
    private String openid;

    @Null
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u == null ? null : u.trim();
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p == null ? null : p.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	@Override
	public String toString() {
		return "PxUser [id=" + id + ", u=" + u + ", p=" + p + ", nickname=" + nickname + ", icon=" + icon + ", status="
				+ status + ", openid=" + openid + ", time=" + time + "]";
	}

	
}