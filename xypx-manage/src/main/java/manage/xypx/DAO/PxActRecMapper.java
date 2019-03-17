package manage.xypx.DAO;

import manage.xypx.Model.PxActRec;

public interface PxActRecMapper {
	
	PxActRec selectByAid(String aid);
	
    int insert(PxActRec record);

    int insertSelective(PxActRec record);
    
    int deleteByActId(String aid);
}