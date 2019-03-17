package manage.xypx.Service.Interface;

import java.util.List;
import java.util.Map;

import manage.xypx.Enums.PXTagEnum;
import manage.xypx.Model.PxTag;

public interface PxTagServiceInterface {
	
	List<PxTag> getTagList(Map<String,Object> map,PXTagEnum type);
	
	int getTagTotal(Map<String,Object> map,PXTagEnum type);
	
	int addTag(PXTagEnum type,String name);
	
	int renameTag(PXTagEnum type,int id,String name);
	
	int deleteTag(PXTagEnum type,int id);
}
