package com.normal.common.utils;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class DataUtils {
	private static final Log logger = LogFactory.getLog(DataUtils.class);
	/**
	 * 产生随机唯一编码
	 * @return
	 */
	public static String generateUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


	/**
     * 生成随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
      String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      Random random = new Random();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < length; i++) {
        int number = random.nextInt(base.length());
        sb.append(base.charAt(number));
      }
      return sb.toString();
    }
    
    /**
     * 处理分页相关数据
     * @param length
     * @return
     */
    public static Map<String,Object> handlePageData(Map<String,Object> paraMap, int count){
    	Map<String,Object> pageMap = new HashMap<String, Object>();
    	pageMap.put("currPage", Integer.parseInt(paraMap.get("page").toString())+1);
		//分页用到的数据
		int remainder = count%Integer.parseInt(paraMap.get("length").toString());
		int totalPage = count/Integer.parseInt(paraMap.get("length").toString());
		if(remainder != 0){
			totalPage = count/Integer.parseInt(paraMap.get("length").toString()) + 1;
		}
		pageMap.put("totalPage", totalPage);
		pageMap.put("length", paraMap.get("length"));
    	return pageMap;
    }

	public static String getLanguagePage(HttpServletRequest req, String page) {
		
		String language = "cn";
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("language")){
					language = cookie.getValue();
					break;
				}
			}
		}
		
		if(!language.equals("cn")){
			page = page + "_" + language;
		}
		
		return page + ".jsp";
	}
	
	public static String hideStr(String str,int showLen){
		if(str!=null && str.length()>=showLen){
			String temp=str.substring(0, showLen);
			for(int i=showLen;i<str.length();i++){
				temp+="*";
			}
			return temp;
		}else return str;
	}
	public static String getCookie(HttpServletRequest req,String cookieName){
		String str=null;
		Cookie[] cookies=req.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(cookieName))
				return cookie.getValue();
		}
		return str;
	}
	public static boolean validateRequest(HttpServletRequest req){
		//return true;
		
		Object obj=req.getSession().getAttribute("accessToken");
		Object obj2=req.getParameter("token");
		
		if(obj!=null && obj2!=null){
			System.out.println(obj.toString());
			System.out.println(obj2.toString());
			if(obj.toString().equals(obj2.toString())){
				
				return true;
			}
		}
		return false;
	}
	
	public static Map<String, Object> simplePageHandler(HttpServletRequest req,Map<String, Object> map,int defaultSize){
		int page,size;
		
		try{
			if(req.getParameter("p")!=null)page=Integer.parseInt(req.getParameter("p").toString());
			else page=1;
		}catch(Exception ex){page=1;}
		
		try{
			if(req.getParameter("l")!=null)size=Integer.parseInt(req.getParameter("l").toString());
			else size=defaultSize;
		}catch(Exception ex){size=defaultSize;}
		size=size>20?20:size;
		
		map.put("start", (page-1)*size);
		map.put("length", size);
		return map;
	}
	

	public static String getCurrUrl(HttpServletRequest request){
		String currUrl = "http://" + request.getServerName();
		int port=request.getServerPort();
		if(port!=80)currUrl+= ":" +port;
		currUrl+= request.getContextPath();
		currUrl+= request.getServletPath();
		String qs=request.getQueryString();
		if(qs!=null)currUrl+="?"+qs;
		return currUrl;
	}
	
	public static void simplePrint(HttpServletResponse repon,String str) throws IOException{
		repon.setHeader("content-type", "application/json;charset=UTF-8");
		repon.getWriter().print(str);
	}
	
	public static boolean isLetterAndNumber(String str){
		String regex = "(?i)^(?!([a-z]*|\\d*)$)[a-z\\d]+$";
		return str.matches(regex);
	}
	
	public static boolean isWeChat(HttpServletRequest req){
		String ua = req.getHeader("user-agent") .toLowerCase();  
		return ua.indexOf("micromessenger") > 0;
	}
	
	public static boolean isMobileBrowser(HttpServletRequest req){
		String ua = req.getHeader("user-agent") .toLowerCase();  
	    String[] Agents =new String[]{"Android", "iPhone",
			                "SymbianOS", "Windows Phone",
			                "iPad", "iPod","mobile"};
	    for(int i=0;i<Agents.length;i++){
	    	if(ua.indexOf(Agents[i])>0)return true;
	    }
		return false;
	}
	
	public static boolean verifyCode(HttpServletRequest req,String v){
		return true;
		/*
		 HttpSession session = req.getSession();
		 if(session.getAttribute("validateCode")!=null){
			 String verify=session.getAttribute("validateCode").toString();
			 if(verify.equals(verify)){
				 session.removeAttribute("validateCode");
				 return true;
			 }
		 }
	     return false;   */
	}
	

	
	
	public static void main(String[] args){
		System.out.println(DataUtils.isLetterAndNumber("zxk1997"));
	}
}
