package manage.xypx.Model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PxUser {
    private String id;

    @JsonProperty("username")
    private String u;

    @JsonIgnore
    private String p;

    private String nickname;

    private String icon;

    private Integer status;

    private String openid;

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