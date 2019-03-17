package manage.xypx.Service.Interface;

import java.util.List;
import java.util.Map;

import manage.xypx.Model.PxActBase;
import manage.xypx.Model.PxActDetail;
import manage.xypx.Model.PxActReview;

public interface PxActServiceInterface {
	
	List<PxActReview> getActList(Map<String, Object> map);
	
	int deleteAct(String id,int type);
	
	int setPush(String id,int type);
	
	List<PxActBase> getReviewAct(Map<String, Object> map);
	
	PxActDetail getAct(String id);
	
	int setActStatus(String id,int type,boolean status);
	
	List<PxActBase> getPushActList(Map<String, Object> map);
	
	int deletePush(String id);
	
	int getActTotal(Map<String, Object> map);
	
	int getPushActTotal(Map<String, Object> map);
}
