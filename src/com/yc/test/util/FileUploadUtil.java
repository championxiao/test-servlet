package com.yc.test.util;


import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;



public class FileUploadUtil {
	public static String PATH="../pics";
	private static final String ALLOWEDLIST="gif,jpg,png,jpeg,doc,xls,xlsx,txt";
	private static final int MAXFILESIZE=10*1024*1024;
	private static final int TOTALMAXSIZE=100*1024*1024;
	private String basePath;
	
	@SuppressWarnings("unchecked")
	public Map<String, String> upload(PageContext pagecontext) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);
		
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
        su.setCharset("utf-8");
        su.upload();
        Request req = su.getRequest();
        Enumeration<String> enums = req.getParameterNames();
        String name = null;
        while(enums.hasMoreElements()) {
        	name = enums.nextElement();
        	map.put(name, req.getParameter(name));
        }
        Files files = su.getFiles();
        if(files == null || files.getCount() <=0) {
        	return map;
        }
        Collection<File> fls = files.getCollection();
        basePath = pagecontext.getServletContext().getRealPath("/");
        String fieldName = null;
        String fileName = null;
        String temp = null;
        String pathStr = "";
        for(File fl : fls) {
        	if(!fl.isMissing()) {
        		temp = fl.getFieldName();
        		if(StringUtil.checkNull(fieldName)) {
        			fieldName = temp;
        		}else {
        			if(!temp.equals(fieldName)) {
        				map.put(fieldName, pathStr);
        				pathStr = "";
        				fieldName = temp;
        			}
        		}
        		fileName = PATH+"/"+new Date().getTime()+"_"+fl.getFileName();
        		if(StringUtil.checkNull(pathStr)) {
        			pathStr = fileName;
        		}else {
        			pathStr += ","+fileName;
        		}
        		 fl.saveAs(basePath+fileName,SmartUpload.SAVE_PHYSICAL);
        	}
        }
        map.put(fieldName,pathStr);
        return map;
	}
	public Map<String, String> uploadPic(PageContext pagecontext) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);
		
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
        su.setCharset("utf-8");
        su.upload();
       
        Files files = su.getFiles();
        if(files == null || files.getCount() <=0) {
        	return map;
        }
        Collection<File> fls = files.getCollection();
        basePath = pagecontext.getServletContext().getRealPath("/");
        String fieldName = null;
        String fileName = null;
        String uploadPath = null;
        for(File fl : fls) {
        	if(!fl.isMissing()) {
        		fieldName = fl.getFieldName();
        		fileName = fl.getFileName();
        		uploadPath = PATH + "/" + new Date().getTime()+"_"+fileName;
        		 fl.saveAs(basePath+uploadPath,SmartUpload.SAVE_PHYSICAL);
        	}
        }
        map.put(fieldName,uploadPath);
        map.put("fileName",fileName);
        return map;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T upload(Class<T> clazz,PageContext pagecontext) throws Exception{
		T t =clazz.newInstance();
		
		SmartUpload su = new SmartUpload();
		su.initialize(pagecontext);
		
		su.setMaxFileSize(MAXFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setAllowedFilesList(ALLOWEDLIST);
        su.setCharset("utf-8");
        su.upload();
        Request req = su.getRequest();
        Enumeration<String> enums = req.getParameterNames();
        Method[] methods = clazz.getMethods();
        Map<String, Method> setters = new HashMap<String, Method>(); 
        String methodName = null;
        for(Method md: methods) {
        	methodName=md.getName();
        	if(methodName.startsWith("set")) {
        		setters.put(methodName, md);
        	}
        }
        String name = null;
        Class<?>[] types=null;
        Class<?> type =null;
        Method method = null;
        while(enums.hasMoreElements()) {
        	name=enums.nextElement();
        	methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
        	method = setters.get(methodName);
        	if(method == null) {
        		continue;
        	}
        	types=method.getParameterTypes();
        	if(types==null) {
        		continue;
        	}
        	type = types[0];
        	if(Integer.TYPE == type || Integer.class == type) {
				method.invoke(t, Integer.valueOf(req.getParameter(name)));
			}else if(Float.TYPE == type || Float.class == type) {
				method.invoke(t, Float.valueOf(req.getParameter(name)));
			}else if(Double.TYPE == type || Double.class == type) {
				method.invoke(t, Double.valueOf(req.getParameter(name)));

			}else {
				method.invoke(t, req.getParameter(name));

			}
        }
        Files files = su.getFiles();
        if(files == null || files.getCount() <=0) {
        	return t;
        }
        Collection<File> fls = files.getCollection();
        basePath = pagecontext.getServletContext().getRealPath("/");
        String fieldName = null;
        String fileName = null;
        String temp = null;
        String pathStr = "";
        for(File fl : fls) {
        	if(!fl.isMissing()) {
        		temp = fl.getFieldName();
        		if(StringUtil.checkNull(fieldName)) {
        			fieldName = temp;
        		}else {
        			if(!temp.equals(fieldName)) {
        				methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
        				method = setters.get(methodName);
        				if(method == null) {
        					continue;
        				}
        				types = method.getParameterTypes();
        				if(types==null) {
        					continue;
        				}
        				method.invoke(t, pathStr);
        				pathStr = "";
        				fieldName = temp;
        			}
        		}
        		fileName = PATH+"/"+new Date().getTime()+"_"+fl.getFileName();
        		if(StringUtil.checkNull(pathStr)) {
        			pathStr = fileName;
        		}else {
        			pathStr += ","+fileName;
        		}
        		 fl.saveAs(basePath+fileName,SmartUpload.SAVE_PHYSICAL);
        	}
        }
		methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
		method = setters.get(methodName);
		if(method==null) {
			return t;
		}
		types = method.getParameterTypes();
		if(types==null) {
			return t;
		}
		method.invoke(t, pathStr);
		return t;
        
	}
	
}
