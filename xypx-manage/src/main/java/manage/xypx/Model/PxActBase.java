package manage.xypx.Model;

public class PxActBase {
	private String id;
	private int type;
	private String name;
	private String summary;
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PxActBase [id=" + id + ", type=" + type + ", name=" + name + ", summary=" + summary + "]";
	}

	
	
}
