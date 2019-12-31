package com.mq.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mq.bean.Brand;
import com.mq.bean.Goods;
import com.mq.bean.GoodsKind;
import com.mq.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService gs;

	@RequestMapping("list")
	public String selectAll(@RequestParam(defaultValue = "1") int pageNum, Model m, String name) {
		PageHelper.startPage(pageNum, 3);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		List<Goods> list = gs.selectAll(map);
		PageInfo<Goods> plist = new PageInfo<Goods>(list);
		m.addAttribute("plist", plist);
		return "list";

	}
	
	@RequestMapping("showOne")
	@ResponseBody
	public List<Brand> selectBrand(){
		return gs.selectBrand();
		
	}
	
	@RequestMapping("showTwo")
	@ResponseBody
	public List<GoodsKind> selectGoodsKind(){
		return gs.selectGoodsKind();
		
	}
	
	@RequestMapping("add")
	public String  insertGoods(Goods good,HttpServletRequest req, @RequestParam("i") MultipartFile myFile) throws IOException{
		
		String realPath = req.getServletContext().getRealPath("upload");
		String fileName = myFile.getOriginalFilename();
		File srcFile = new File(realPath + "/" + fileName);
		InputStream is = myFile.getInputStream();
		OutputStream os = new FileOutputStream(srcFile);
		String locat = "upload/" + fileName;
		req.setAttribute("locat", locat);
		good.setImg(locat);
		
		IOUtils.copy(is, os);
		os.flush();
		os.close();
		is.close();
		int i = gs.insertGoods(good);
		if(i>0){
			return "redirect:list.do";
		}
		
		return "add";
		
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Goods selectOne(int id){
		
		return gs.selectOne(id);
		
	}
	
	@RequestMapping("update")
	public String updateGoods(Goods good,HttpServletRequest req, @RequestParam("i") MultipartFile myFile) throws IOException{
		String realPath = req.getServletContext().getRealPath("upload");
		String fileName = myFile.getOriginalFilename();
		File srcFile = new File(realPath + "/" + fileName);
		InputStream is = myFile.getInputStream();
		OutputStream os = new FileOutputStream(srcFile);
		String locat = "upload/" + fileName;
		req.setAttribute("locat", locat);
		good.setImg(locat);
		
		IOUtils.copy(is, os);
		os.flush();
		os.close();
		is.close();
		int i = gs.updateGoods(good);
		if(i>0){
			return "redirect:list";
		}
		return "update";
		
	}
	
	@RequestMapping("dels")
	@ResponseBody
	public int delsGoods(String ids[]){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ids", ids);
		
		return gs.delsGoods(map);
		
	}
	
	@RequestMapping("delOne")
	public String deleteOne(int id){
		int i = gs.deleteOneGoods(id);
		return "redirect:list";
		
	}

}
