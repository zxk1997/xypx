package test;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import manage.xypx.Model.PxAct;
import manage.xypx.Model.PxUser;

public class RandomUtils {
	private final static String[] images = { "http://120.78.83.14:2000/get/8ffa0e56-1b0b-4954-b4c7-1d5b768d8a6b",
			"http://120.78.83.14:2000/get/7b6630ab-319e-4dc6-909d-a8d2f97f28ce",
			"http://120.78.83.14:2000/get/883850d6-28e6-41db-8569-3e6aa31ee056",
			"http://120.78.83.14:2000/get/e9158190-c2fc-45f7-92f7-630180e9dad1",
			"http://120.78.83.14:2000/get/e53767c4-3f50-4874-97cf-bbcea688def9" };

	private static char getRandomChar() {
		String str = "";
		int hightPos; //
		int lowPos;

		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
			str = new String(b, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("错误");
		}

		return str.charAt(0);
	}

	public static String getImage() {
		return images[getNumber(0, 4)];
	}

	public static int getNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getLetter(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append((char)(97+getNumber(0,25)));
		}
		return sb.toString();
	}

	public static String getName(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(getRandomChar());
		}
		return sb.toString();
	}
	
	public static PxUser getUser() {
		PxUser user=new PxUser();
		user.setId(getUUID());
		user.setU(getLetter(6)+getNumber(0, 99));
		user.setP("4746191fed3ee8528573fd053991bdbd");
		user.setNickname(getName(5));
		user.setIcon(getImage());
		user.setStatus(1);
		user.setTime(new Date());
		return user;
		
	}
	private static String getRandomContent() {
		StringBuilder sb=new StringBuilder();
		sb.append("<div style=\"text-align:center;\"><strong>以下内容是随机生成的</strong></div>");
		
		for(int i=0;i<5;i++) {
			
			sb.append("<div style=\"text-align:"+(getNumber(0, 5)>=3?"center":"left")+";\">");
			
			int a=getNumber(0, 2);
			switch (a) {
			case 0:
				sb.append("<img src='"+getImage()+"' alt=\"\" />");
				break;
			case 1:
				sb.append("<p style='text-align:left;'>"+getName(getNumber(5, 30))+"</p>");
				break;
			case 2:
				sb.append("<span style='font-size:16px;'>"+getName(getNumber(5, 30))+"</span>");
				break;
			}
			
			sb.append("</div>");
		}

		
		return sb.toString();
	}
	public static PxAct getAct(PxUser p) {
		PxAct act=new PxAct();
		act.setId(getUUID());
		act.setTitle("随机生成-"+getName(getNumber(5, 10)));
		act.setAddress(getName(getNumber(15, 20)));
		act.setPhone("13612345678");
		Date d=new Date();
		act.setS(d);
		act.setPs(d);
		d=new Date();
		d.setHours(10000);
		act.setE(d);
		act.setPe(d);
		act.setPlacard(getImage());
		act.setPlimit(0);
		act.setSummary(getName(getNumber(20, 40)));
		act.setTime(d);
		act.setStatus(1);
		act.setUid(p.getId());
		act.setContent(getRandomContent());
		return act;
	}

	public static void main(String[] args) throws ParseException {
		
		
        
		System.out.println(getAct(getUser()));
	}
}
