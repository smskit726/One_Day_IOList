package com.biz.iolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		List<ProductVO> proList = productDao.selectAll();
		
		model.addAttribute("PRODUCTS", proList);
		model.addAttribute("BODY","PRO-LIST");
		return "home";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		
		LocalDateTime lDateTime = LocalDateTime.now();
		String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String lTime = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);

		ProductVO proVO = ProductVO.builder()
										.io_date(lDate)
										.io_time(lTime)
										.build();
		
		model.addAttribute("PROVO", proVO);
		model.addAttribute("BODY", "PRO-WRITE");
		return "home";
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("PROVO") ProductVO proVO) {
		
		log.debug(proVO.toString());
		proVO.setIo_total(proVO.getIo_price() * proVO.getIo_quan());
		int ret = productDao.insert(proVO);
		if(ret<1) {
			log.debug("DATA INSERT ERROR");
		}
		return "redirect:/";
	}
	
}
