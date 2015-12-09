package cn.itcast.core.service.product;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.common.junit.SpringJunitTest;
import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;

public class BrandServiceImplTest extends SpringJunitTest{

	@Autowired
	private BrandService brandService;
	
	@Test
	public void testGetBrandList() {
		Brand brand=new Brand();
		brand.setPageNo(2);
		Pagination pagination=brandService.getBrandListWithPage(brand);
		System.out.println(pagination.getList());
		System.out.println(pagination.getList().size());
	}
	
	@Test
	public void testAddBrand() {
		Brand brand=new Brand();
		brand.setName("金乐乐");
		brand.setImgUrl("upload/20151206224620180496.jpg");
		brand.setSort(20);
		brand.setIsDisplay(1);
		brandService.addBrand(brand);
	}

}
