package com.korea.demo.service.yedana;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.demo.dao.yedana.YedanaDAO;
import com.korea.demo.vo.yedana.YedanaVO;

@Service
public class YedanaService {
	@Autowired
	private YedanaDAO dao;
	
	public List<YedanaVO> yedanaList(){
		System.out.println("DAO 호출전");
		List<YedanaVO> list = dao.yedanaList();
		System.out.println("DAO 호출후");
		return list;
	}
	
	
	
}
