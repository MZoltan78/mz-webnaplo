package com.mz.webnaplo.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mz.webnaplo.domains.fileupload.UploadedFile;
import com.mz.webnaplo.response.StatusResponse;

// @Controller
@RequestMapping("/upload")
public class FileUploadController {

	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String getFileUploadPage() 
	{
		return "upload";
	}

	@RequestMapping(value="/message", method=RequestMethod.POST)
	public @ResponseBody StatusResponse message() 
	{
		System.out.println("message triggered....");
		logger.debug("Fileupload service processing.....done");
		return new StatusResponse(true, "Message received");
	}

	@RequestMapping(value="/file", method=RequestMethod.POST)
	public @ResponseBody List<UploadedFile> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) 
	{
		System.out.println("upload clicked....");
		// a multiparthoz kell egy multipart resolver (ui-servlet-context.xml)
		logger.debug("Writing file to disk.....done");
		List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>(1);
		UploadedFile u = new UploadedFile();
		u.setName(file.getOriginalFilename());
		u.setSize(Long.valueOf(file.getSize()).intValue());
		u.setUrl(getContextPathUrl(request, "/resources/"+file.getOriginalFilename()));
		uploadedFiles.add(u);
		return uploadedFiles;
	}
	
	private String getContextPathUrl(HttpServletRequest request, String postfix)
	{
		String s = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + postfix;
		System.out.println("########## "+s);
		return s;
	}
	
}
