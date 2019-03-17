package manage.xypx.DAO;

import manage.xypx.Model.PxUserPartake;

public interface PxUserPartakeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PxUserPartake record);

    int insertSelective(PxUserPartake record);

    PxUserPartake selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PxUserPartake record);

    int updateByPrimaryKey(PxUserPartake record);
}