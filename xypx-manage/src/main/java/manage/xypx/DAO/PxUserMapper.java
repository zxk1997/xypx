package manage.xypx.DAO;

import java.util.HashMap;
import java.util.List;

import manage.xypx.Model.PxUser;

public interface PxUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(PxUser record);

    int insertSelective(PxUser record);

    PxUser selectByPrimaryKey(String id);
    
    int updateByPrimaryKeySelective(PxUser record);

    int updateByPrimaryKey(PxUser record);
    
    String selectUserAuthFileById(String id);
    
    List<PxUser> selectAll(HashMap<String, Object> map);
    
  
    List<PxUser> selectByConditions(HashMap<String, Object> map);
    
    int selectTotalByConditions(HashMap<String, Object> map);

}