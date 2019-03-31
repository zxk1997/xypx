package com.zxk.xypx.mfs.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

@Controller
public class ImgFileController {

	@Autowired
	GridFsTemplate gridFsTemplate;
	@Autowired
	GridFSBucket gridFSBucket;

	@PostMapping(value = "/upload")
	public void uploadSample(@RequestBody MultipartFile file, HttpServletResponse resp, HttpServletRequest req)
			throws IOException {
		String fileName = UUID.randomUUID().toString();
		DBObject metaData = new BasicDBObject();
		metaData.put("time", new Date());
		InputStream inputStream = null;

		HashMap<String, Object> map = new HashMap<>();
		map.put("error", 1);
		map.put("url", "");

		try {
			inputStream = file.getInputStream();
			gridFsTemplate.store(inputStream, fileName, "image", metaData);

			String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath() + "/";

			map.put("error", 0);
			map.put("url", basePath + "get/" + fileName);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String callBack = req.getParameter("callback");
		if (callBack != null) {
			resp.sendRedirect(callBack + "?error=" + map.get("error") + "&url=" + map.get("url"));
		} else {
			Gson g = new Gson();
			resp.setContentType("application/json");
			resp.getWriter().println(g.toJson(map));
			resp.flushBuffer();
		}

	}

	@GetMapping(value = "/get/{filename}")
	public void get(@PathVariable String filename, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Query q = Query.query(Criteria.where("filename").is(filename));
		GridFSFile file = gridFsTemplate.findOne(q);

		if (file != null) {
			GridFSDownloadStream gridFS = gridFSBucket.openDownloadStream(file.getObjectId());
			GridFsResource gridFsResource = new GridFsResource(file, gridFS);
			response.setContentType("image/jpeg");
			IOUtils.copy(gridFsResource.getInputStream(), response.getOutputStream());
			response.flushBuffer();
		}

	}

}
