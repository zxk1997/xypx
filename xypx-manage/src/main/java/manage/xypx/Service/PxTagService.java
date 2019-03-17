package manage.xypx.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.xypx.DAO.PxTagActMapper;
import manage.xypx.DAO.PxTagPersMapper;
import manage.xypx.Enums.PXTagEnum;
import manage.xypx.Model.PxTag;
import manage.xypx.Service.Interface.PxTagServiceInterface;
@Service
public class PxTagService implements PxTagServiceInterface {

	@Autowired
	PxTagActMapper act;
	
	@Autowired
	PxTagPersMapper per;
	
	@Override
	public List<PxTag> getTagList(Map<String, Object> map, PXTagEnum type) {
		map.put("type", type.getName());
		return act.selectTagsByConditions(map);
	}

	@Override
	public int getTagTotal(Map<String, Object> map, PXTagEnum type) {
		map.put("type", type.getName());
		return act.selectTagTotalByConditions(map);
	}

	@Override
	public int addTag(PXTagEnum type, String name) {
		
		PxTag tag=new PxTag();
		tag.setI(0);
		tag.setName(name);
		
		if(type==PXTagEnum.ACT) {
			if(act.selectByName(name)!=null)return -1;
			return act.insert(tag);
		}else {
			if(per.selectByName(name)!=null)return -1;
			return per.insert(tag);
		}
		
	}

	@Override
	public int renameTag(PXTagEnum type, int id, String name) {
		PxTag tag=new PxTag();
		tag.setId(id);
		tag.setName(name);
		if(type==PXTagEnum.ACT) {
			return act.updateByPrimaryKeySelective(tag);
		}else {
			return per.updateByPrimaryKeySelective(tag);
		}
		
	}

	@Override
	public int deleteTag(PXTagEnum type, int id) {
		
		if(type==PXTagEnum.ACT) {
			return act.deleteByPrimaryKey(id);
		}else {
			return per.deleteByPrimaryKey(id);
		}
	}

}
