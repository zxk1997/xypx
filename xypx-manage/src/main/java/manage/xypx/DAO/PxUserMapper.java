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
    
    /**
     * map可传参数：
     * start和length 代表查询开始的位置和读取的数量 （用于分页）
     * status 传入0代表查询未实名的用户  1代表查询已经实名的用户 -1代表查询待审核的用户
     * str 传入模糊匹配的字符串
     * */
    List<PxUser> selectByConditions(HashMap<String, Object> map);
    
    int selectTotalByConditions(HashMap<String, Object> map);

}