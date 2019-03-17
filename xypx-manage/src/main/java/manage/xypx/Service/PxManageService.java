package manage.xypx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manage.xypx.DAO.PxManageUserMapper;
import manage.xypx.Model.PxManageUser;
import manage.xypx.Service.Interface.PxManageServiceInterface;

@Service
public class PxManageService implements PxManageServiceInterface {

	@Autowired
	PxManageUserMapper manage;
	
	@Override
	public PxManageUser login(String user, String pwd) {
		return manage.selectByAccount(user, pwd);
	}

}
