package com.biz.iolist.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("pService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao proDao;

	@Override
	public List<ProductVO> selectAll() {
		return proDao.selectAll();
	}

	@Override
	public ProductVO findById(Long id) {
		
		return proDao.findById(id);
	}

	@Override
	public int insert(ProductVO proVO) {
		LocalDateTime lDateTime = LocalDateTime.now();
		String lDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String lTime = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);

		proVO.setIo_date(lDate);
		proVO.setIo_time(lTime);
		proVO.setIo_total(proVO.getIo_price() * proVO.getIo_quan());
		
		int ret = proDao.insert(proVO);
		if(ret > 0) {
			log.debug("INSERT 성공 {}개 데이터 추가", ret);
		} else {
			log.debug("INSERT 실패 :(");
		}
		return ret;
	}

	@Override
	public int update(ProductVO proVO) {
		
		proVO.setIo_total(proVO.getIo_price() * proVO.getIo_quan());
		int ret = proDao.update(proVO);
		if(ret > 0) {
			log.debug("UPDATE 성공 {}개 데이터 수정",ret);
		} else {
			log.debug("UPDATE 실패 :(");
		}
		return ret;
	}

	@Override
	public int delete(Long id) {
		
		int ret = proDao.delete(id);
		if(ret >0) {
			log.debug("DELETE 성공 {}개 데이터 추가",ret);
		} else {
			log.debug("DELETE 실패 :(");
		}
		return ret;
	}

}
