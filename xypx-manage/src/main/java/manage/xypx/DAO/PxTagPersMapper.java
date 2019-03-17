package manage.xypx.DAO;

import manage.xypx.Model.PxTag;

public interface PxTagPersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PxTag record);

    int insertSelective(PxTag record);

    PxTag selectByPrimaryKey(Integer id);
    
    PxTag selectByName(String name);

    int updateByPrimaryKeySelective(PxTag record);

    int updateByPrimaryKey(PxTag record);
}