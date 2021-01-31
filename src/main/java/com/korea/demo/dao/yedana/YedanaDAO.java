package com.korea.demo.dao.yedana;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.demo.vo.yedana.YedanaVO;

@Repository
public class YedanaDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<YedanaVO> yedanaList(){
		System.out.println("디비 호출전");
		List<YedanaVO> list = sqlSession.selectList("yedana.yedana_list");
		for(YedanaVO vo : list) {
			System.out.println(vo.getName());
		}
		System.out.println("디비 호출후");
		return list;
	}
}
