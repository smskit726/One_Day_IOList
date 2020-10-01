package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@Qualifier("pService")
	private final ProductService pService;
	
	@Transactional
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		List<ProductVO> proList = pService.selectAll();
		
		model.addAttribute("PRODUCTS", proList);
		model.addAttribute("BODY","PRO-LIST");
		return "home";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@ModelAttribute("PROVO") ProductVO proVO, Model model) {
		
		model.addAttribute("PROVO", proVO);
		model.addAttribute("BODY", "PRO-WRITE");
		return "home";
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("PROVO") ProductVO proVO) {
				
		pService.insert(proVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Long seq, Model model) {
		
		ProductVO proVO = pService.findById(seq);
		log.debug(proVO.toString());
		model.addAttribute("PROVO", proVO);
		model.addAttribute("BODY", "PRO-DETAIL");
		
		return "home";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long seq, Model model) {
		
		pService.delete(seq);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String update(@RequestParam("id") Long seq, @ModelAttribute("PROVO") ProductVO proVO, Model model) {
		
		proVO = pService.findById(seq);
		model.addAttribute("PROVO", proVO);
		model.addAttribute("BODY","PRO-WRITE");
		return "home";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("PROVO") ProductVO proVO, Model model) {
		
		pService.update(proVO);
		
		return "redirect:/";
	}
}
