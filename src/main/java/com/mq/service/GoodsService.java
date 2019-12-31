package com.mq.service;

import java.util.List;
import java.util.Map;

import com.mq.bean.Brand;
import com.mq.bean.Goods;
import com.mq.bean.GoodsKind;

public interface GoodsService {
	
	public List<Goods> selectAll(Map<String,Object> map);
	
	public List<Brand> selectBrand();
	public List<GoodsKind> selectGoodsKind();
	
	public int insertGoods(Goods good);
	
	public Goods selectOne(int id);

	public int updateGoods(Goods good);
	
	public int delsGoods(Map<String,Object> map);
	
	public int deleteOneGoods(int id);
}
