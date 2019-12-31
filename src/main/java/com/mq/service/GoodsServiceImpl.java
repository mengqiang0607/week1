package com.mq.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mq.bean.Brand;
import com.mq.bean.Goods;
import com.mq.bean.GoodsKind;
import com.mq.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsMapper gm;

	public List<Goods> selectAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gm.selectAll(map);
	}

	public List<Brand> selectBrand() {
		// TODO Auto-generated method stub
		return gm.selectBrand();
	}

	public List<GoodsKind> selectGoodsKind() {
		// TODO Auto-generated method stub
		return gm.selectGoodsKind();
	}

	public int insertGoods(Goods good) {
		// TODO Auto-generated method stub
		return gm.insertGoods(good);
	}

	public Goods selectOne(int id) {
		// TODO Auto-generated method stub
		return gm.selectOne(id);
	}

	public int updateGoods(Goods good) {
		// TODO Auto-generated method stub
		return gm.updateGoods(good);
	}

	public int delsGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gm.delsGoods(map);
	}

	public int deleteOneGoods(int id) {
		// TODO Auto-generated method stub
		return gm.deleteOneGoods(id);
	}


}
