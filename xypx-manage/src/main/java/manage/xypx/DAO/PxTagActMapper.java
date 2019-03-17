package manage.xypx.DAO;

import java.util.List;
import java.util.Map;

import manage.xypx.Model.PxTag;

public interface PxTagActMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PxTag record);

    int insertSelective(PxTag record);

    PxTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PxTag record);

    int updateByPrimaryKey(PxTag record);
    
    List<PxTag> selectTagsByConditions(Map<String,Object> map);
    
    int selectTagTotalByConditions(Map<String,Object> map);
    
    PxTag selectByName(String name);
}