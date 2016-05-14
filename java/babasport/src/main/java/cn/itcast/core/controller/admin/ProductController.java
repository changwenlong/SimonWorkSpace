package cn.itcast.core.controller.admin;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.common.web.springmvc.Constants;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;
import cn.itcast.core.query.product.ProductQuery;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.service.product.ProductService;

/**
 * 后台商品管理
 * 商品列表
 * 商品添加
 * 商品上架
 * 
 * @author chwl
 * @Date 2016年2月20日 下午9:39:18
 */
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ProductService productService;
	
	//商品列表
	@RequestMapping(value="/list.do")
	public String list(Integer pageNo,String name,Integer brandId,Integer isShow,ModelMap model){
		
		//默认加载品牌
				BrandQuery brandQuery = new BrandQuery();
				//设置 可见不可见
				brandQuery.setIsDisplay(Constants.YES);
				//设置只要Id Name
				brandQuery.setFields("id,name");
				
				List<Brand> brands = brandService.getBrandList(brandQuery);
				
				model.addAttribute("brands", brands);
				model.addAttribute("brandId", brandId);

		StringBuilder params = new StringBuilder();
		
		//设置条件的对象
				ProductQuery productQuery = new ProductQuery();
				//默认加载
				//1:设置未删除
				productQuery.setIsDel(Constants.YES);
				//2:设置下架状态
				productQuery.setIsShow(Constants.NO);
				
				productQuery.orderbyId(false);
				
				//Blank 1:去掉二侧的空串,再判断是否为空串   ""   "     "
				//Empty  直接判断是否为空串    ""  "      "
				//拼接查询条件
				if(null != name && StringUtils.isNotBlank(name)){
					productQuery.setName(name);
					params.append("&")
						  .append("name=" + name);
				}
				//品牌ID
				if(null != brandId){
					productQuery.setBrandId(brandId);
					params.append("&")
						  .append("brandId=" + brandId);
				}
				//上下架
				if(null != isShow){
					productQuery.setIsShow(isShow);
					params.append("&")
						  .append("isShow=" + isShow);
					model.addAttribute("isShow", isShow);
				}else{
					model.addAttribute("isShow", 0);
				}
				productQuery.setPageNo(Pagination.cpn(pageNo));//1 10
				
				productQuery.setPageSize(3);

		
		return "product/list";
	}
}
