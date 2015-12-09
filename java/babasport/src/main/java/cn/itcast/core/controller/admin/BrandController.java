package cn.itcast.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.product.BrandService;

/**
 * 品牌
 * 
 * @author chwl
 * @Date 2015年12月6日 下午4:06:36
 */
@Controller
@RequestMapping(value="/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	//品牌列表页面
	@RequestMapping(value="/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		StringBuilder params=new StringBuilder();
		Brand brand=new Brand();
		if(StringUtils.isNotBlank(name)){
			brand.setName(name);
			params.append("name=").append(name);
		}
		if(null == isDisplay){
			brand.setIsDisplay(1);
			params.append("&isDisplay=").append(1);
		}else{
			brand.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay);
		}
		//如果页号为null 或小于1  置为1
		
		//页号
		brand.setPageNo(Pagination.cpn(pageNo));
		Pagination pagination=brandService.getBrandListWithPage(brand);
		
		//分页展示   /brand/list.do?name=瑜伽树（yogatree）&isDisplay=1&pageNo=2
		
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", brand.getName());
		model.addAttribute("isDisplay", brand.getIsDisplay());
		return "brand/list";
	}
	
	//跳转添加页面
	@RequestMapping(value="/toAdd.do")
	public String toAdd(){
		return "brand/add";
	}
	
	//添加品牌
	@RequestMapping(value="/add.do")
	public String add(Brand brand){
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}
	
	//删除品牌
	@RequestMapping(value="/delete.do")
	public String delete(String name,Integer isDisplay,Integer id,ModelMap map){
		brandService.deleteBrandById(id);
		map.put("name", name);
		map.put("isDisplay", isDisplay);
		return "redirect:/brand/list.do";
	}
	
	
	//删除品牌 批量
	@RequestMapping(value="/deletes.do")
	public String deletes(String name,Integer isDisplay,Integer[] ids,ModelMap map){
		brandService.deleteBrandByIds(ids);
		map.put("name", name);
		map.put("isDisplay", isDisplay);
		return "redirect:/brand/list.do";
	}
	
	//跳转品牌
	@RequestMapping(value="/toEdit.do")
	public String deletes(Integer id,ModelMap map){
		Brand brand=brandService.getBrandById(id);
		map.put("brand", brand);
		return "brand/edit";
	}
	
	//修改品牌
	@RequestMapping(value="/edit.do")
	public String deletes(Brand brand,ModelMap map){
		brandService.updateBrandById(brand);
		return "redirect:/brand/list.do";
	}
}
