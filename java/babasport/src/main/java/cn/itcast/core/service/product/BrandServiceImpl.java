package cn.itcast.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.dao.product.BrandDao;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	@Resource
	private BrandDao brandDao;
	
	//获取品牌列表
	@Transactional(readOnly=true)
	public Pagination getBrandListWithPage(Brand brand) {
		List<Brand> brandList=brandDao.getBrandListWithPage(brand);
		Pagination pagination=new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		pagination.setList(brandList);
		return pagination;
	}

	//新增品牌
	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);		
	}

	//通过ID刪除品牌
	@Override
	public void deleteBrandById(Integer id) {
		brandDao.deleteBrandById(id);
	}

	//通过ID刪除品牌 批量
	@Override
	public void deleteBrandByIds(Integer[] ids) {
		brandDao.deleteBrandByIds(ids);
	}

	//通过ID修改品牌
	@Override
	public void updateBrandById(Brand brand) {
		brandDao.updateBrandById(brand);
	}

	//通过ID获取品牌信息
	@Override
	public Brand getBrandById(Integer id) {
		return brandDao.getBrandById(id);
	}
	

}
