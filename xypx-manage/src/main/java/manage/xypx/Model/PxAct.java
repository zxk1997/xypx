package manage.xypx.Model;

import java.util.Date;


public class PxAct {
    private String id;

    private String title;

    private String address;

    private String phone;

    private Date s;

    private Date e;

    private Date ps;

    private Date pe;

    private String placard;

    private Integer plimit;

    private String summary;

    private Date time;

    private Integer status;

    private String rm;

    private String uid;

    private String content;

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

	@Override
	public String toString() {
		return "PxAct [id=" + id + ", title=" + title + ", address=" + address + ", phone=" + phone + ", s=" + s
				+ ", e=" + e + ", ps=" + ps + ", pe=" + pe + ", placard=" + placard + ", plimit=" + plimit
				+ ", summary=" + summary + ", time=" + time + ", status=" + status + ", rm=" + rm + ", uid=" + uid
				+ ", content=" + content + "]";
	}
}