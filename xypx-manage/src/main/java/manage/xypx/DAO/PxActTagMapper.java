package manage.xypx.DAO;

import manage.xypx.Model.PxActTag;

public interface PxActTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PxActTag record);

    int insertSelective(PxActTag record);

    PxActTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PxActTag record);

    int updateByPrimaryKey(PxActTag record);
}