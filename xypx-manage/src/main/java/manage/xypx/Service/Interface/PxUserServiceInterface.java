package manage.xypx.Service.Interface;

import java.util.HashMap;
import java.util.List;

import manage.xypx.Model.PxUser;

public interface PxUserServiceInterface {
	
	/*获取全部用户*/
	List<PxUser> getUserByConditions(HashMap<String, Object> map);
	int getUserTotalByConditions(HashMap<String, Object> map);
	/*删除用户*/
	int deleteById(String id);
	
	int updateUser(PxUser user);
	
	int updateUserReview(String id,boolean status);
	
	String getUserAuthFile(String id);
}
