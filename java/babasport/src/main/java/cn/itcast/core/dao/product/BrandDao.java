package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.product.Brand;

public interface BrandDao {
	//获取品牌列表
	List<Brand> getBrandListWithPage(Brand brand);
	
	//查询品牌总数
	Integer getBrandCount(Brand brand);
	
	//新增品牌
	void addBrand(Brand brand);
	
	//通过ID删除品牌
	void deleteBrandById(Integer id);
		
	//通过ID删除品牌 批量
	void deleteBrandByIds(Integer[] ids);
		
	//通过ID获取品牌
	Brand getBrandById(Integer id);
	
	//通过ID修改品牌
	void updateBrandById(Brand brand);
}
