package manage.xypx.DAO;

import org.apache.ibatis.annotations.Param;

import manage.xypx.Model.PxManageUser;

public interface PxManageUserMapper {

	PxManageUser selectByAccount(@Param("user")String user,@Param("pwd")String pwd);
}
