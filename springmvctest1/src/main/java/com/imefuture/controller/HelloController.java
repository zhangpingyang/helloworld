package com.imefuture.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HelloController {

	@RequestMapping(value="hello")
	public String hello(){
		System.out.println("访问到了");
		return "a";
	}
	@RequestMapping(value="path/{path}")
	public String path(@PathVariable("path")String path){
		return path;
	}
	@RequestMapping("fileupload")
	public String fileupload(@RequestParam("file")MultipartFile file, ModelMap model){
		try {
			if (file!=null) {
				file.transferTo(new File("c:/temp/"+file.getOriginalFilename()));
			}
		} catch (IOException e) {
			model.put("msg", "上传失败");
			e.printStackTrace();
			return "error";
		}
		model.put("msg", "成功");
		return "success";
	}
}
