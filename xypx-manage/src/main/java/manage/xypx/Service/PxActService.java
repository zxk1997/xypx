package manage.xypx.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.xypx.DAO.PxActMapper;
import manage.xypx.DAO.PxActRecMapper;
import manage.xypx.DAO.PxLctrMapper;
import manage.xypx.Model.PxAct;
import manage.xypx.Model.PxActBase;
import manage.xypx.Model.PxActDetail;
import manage.xypx.Model.PxActRec;
import manage.xypx.Model.PxActReview;
import manage.xypx.Model.PxLctr;
import manage.xypx.Service.Interface.PxActServiceInterface;

@Service
public class PxActService implements PxActServiceInterface {

	@Autowired
	PxActMapper act;

	@Autowired
	PxLctrMapper lctr;

	@Autowired
	PxActRecMapper rec;

	@Override
	public List<PxActReview> getActList(Map<String, Object> map) {
		
		return act.selectByConditionsToReview(map);
	}

	@Override
	public int deleteAct(String id, int type) {
		if (type == 0)
			return act.deleteByPrimaryKey(id);
		else
			return lctr.deleteByPrimaryKey(id);
	}

	@Override
	public int setPush(String id, int type) {
		if(rec.selectByAid(id)!=null)return -1;
		PxActRec r=new PxActRec();
		r.setAid(id);
		r.setAt(type);
		r.setIndex(0);
		return rec.insertSelective(r);
	}

	@Override
	public List<PxActBase> getReviewAct(Map<String, Object> map) {
		map.put("status", 0);
		return act.selectByConditionsToBase(map);
	}

	@Override
	public PxActDetail getAct(String id) {
		Map<String, Object> map=new HashMap<>();
		map.put("id", id);
		return act.selectByConditions(map).get(0);
	}

	@Override
	public int setActStatus(String id, int type,boolean status) {

		if(type==0) {
			PxAct t=new PxAct();
			t.setId(id);
			t.setStatus(status?1:-1);
			return act.updateByPrimaryKeySelective(t);
		}else {
			PxLctr t=new PxLctr();
			t.setId(id);
			t.setStatus(status?1:-1);
			return lctr.updateByPrimaryKeySelective(t);
		}

	}

	@Override
	public List<PxActBase> getPushActList(Map<String, Object> map) {
		
		return act.selectPushByConditions(map);
	}

	@Override
	public int deletePush(String id) {
		return rec.deleteByActId(id);
	}

	@Override
	public int getActTotal(Map<String, Object> map) {
		
		return act.selectTotalByConditions(map);
	}

	@Override
	public int getPushActTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return act.selectPushTotalByConditions(map);
	}

}
