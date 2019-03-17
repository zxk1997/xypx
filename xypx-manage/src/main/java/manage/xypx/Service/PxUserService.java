package manage.xypx.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.xypx.DAO.PxUserMapper;
import manage.xypx.Model.PxUser;
import manage.xypx.Service.Interface.PxUserServiceInterface;

@Service
public class PxUserService implements PxUserServiceInterface {

	@Autowired
	PxUserMapper userMapper;
	
	@Override
	public List<PxUser> getUserByConditions(HashMap<String, Object> map) {
		return userMapper.selectByConditions(map);
	}

	@Override
	public int deleteById(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(PxUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int updateUserReview(String id,boolean status) {
		PxUser user=new PxUser();
		user.setId(id);
		user.setStatus(status?1:-1);
		return updateUser(user);
	}

	@Override
	public String getUserAuthFile(String id) {
		return userMapper.selectUserAuthFileById(id);
	}

	@Override
	public int getUserTotalByConditions(HashMap<String, Object> map) {
		
		return userMapper.selectTotalByConditions(map);
	}

}
