package manage.xypx.Enums;



public enum PXTagEnum {
	PERS("pers"),ACT("act");
	
	private String name="";
	PXTagEnum(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	
}
