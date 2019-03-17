package manage.xypx.DAO;

import manage.xypx.Model.PxLctr;

public interface PxLctrMapper {
    int deleteByPrimaryKey(String id);

    int insert(PxLctr record);

    int insertSelective(PxLctr record);

    PxLctr selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PxLctr record);

    int updateByPrimaryKeyWithBLOBs(PxLctr record);

    int updateByPrimaryKey(PxLctr record);
}