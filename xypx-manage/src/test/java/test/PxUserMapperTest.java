package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import manage.xypx.Enums.PXTagEnum;
import manage.xypx.Model.PxTag;
import manage.xypx.Model.PxUser;
import manage.xypx.Service.Interface.PxActServiceInterface;
import manage.xypx.Service.Interface.PxTagServiceInterface;
import manage.xypx.Service.Interface.PxUserServiceInterface;

@SpringBootTest(classes=manage.xypx.ManageSpringBootApplication.class)
@RunWith(SpringRunner.class)
public class PxUserMapperTest {

	@Autowired
	PxUserServiceInterface user;

	@Autowired
	PxActServiceInterface act;
	
	@Autowired
	PxTagServiceInterface tag;
	
	@Test
	public void test() {
		
		Map<String, Object>map=new HashMap<>();
//		map.put("start", 0);
//		map.put("length", 10);
//		map.put("status",-1);
//		map.put("str","标题");
//		/*
//		List<PxUser> users=user.getUserByConditions(map);*/
//		List<PxActBase> list=act.selectPushByConditions(map);
//		for(PxActBase base : list)System.out.println(base);
//		System.out.println(list.size());
//		
//		System.out.println(act.selectPushTotalByConditions(map));
		
		List<PxTag> act=tag.getTagList(map,PXTagEnum.ACT);
		System.out.println(tag.addTag(PXTagEnum.ACT, "活动标签"));
		for(PxTag tmp : act)System.out.println(tmp.toString());
		System.out.println(tag.getTagTotal(map, PXTagEnum.ACT));
		
		System.out.println(tag.renameTag(PXTagEnum.ACT, 1, "重命名"));
		System.out.println("============");
		
		List<PxTag> per=tag.getTagList(map,PXTagEnum.PERS);
		System.out.println(tag.addTag(PXTagEnum.PERS, "性格标签"));
		System.out.println(tag.getTagTotal(map, PXTagEnum.PERS));
		for(PxTag tmp : per)System.out.println(tmp.toString());
	}
	
	@Test
	public void getFile() {
		/*
		String a=user.getUserAuthFile("02bca85e00614c00b89d642bb0709b99");
		String b=user.getUserAuthFile("0e509b9ee3204fbcbaf944ae4e05666c");
		System.out.println(a);
		System.out.println(b);*/
//		String id="1deccd2173fb45259cfdf0425a719444";
//		int type=0;
//		System.out.println(act.setActStatus(id, type, false));
		
		
	}
	
	public void consoList(List<PxUser> users) {
		for(PxUser u : users) {
			System.out.println(u);
			System.out.println("--------------");
		}
		System.out.println("==============");
	}

}
