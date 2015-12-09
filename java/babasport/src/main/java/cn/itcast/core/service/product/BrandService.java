package cn.itcast.core.service.product;


import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;

public interface BrandService {
	//获取品牌列表
	Pagination getBrandListWithPage(Brand brand);
	
	//新增品牌
	void addBrand(Brand brand);
	
	//通过ID删除品牌
	void deleteBrandById(Integer id);
	
	//通过ID删除品牌 批量
	void deleteBrandByIds(Integer[] ids);
	
	//通过ID获取品牌信息
	Brand getBrandById(Integer id);
	
	//通过ID修改品牌
	void updateBrandById(Brand brand);
}
