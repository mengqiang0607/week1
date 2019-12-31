package com.mq.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mq.bean.Brand;
import com.mq.bean.Goods;
import com.mq.bean.GoodsKind;

public interface GoodsMapper {
	
	public List<Goods> selectAll(Map<String,Object> map);
	
	public List<Brand> selectBrand();
	public List<GoodsKind> selectGoodsKind();
	
	public int insertGoods(Goods good);
	
	public Goods selectOne(@Param("id")int id);
	
	public int updateGoods(Goods good);
	
	public int delsGoods(Map<String,Object> map);
	
	public int deleteOneGoods(int id);
}
