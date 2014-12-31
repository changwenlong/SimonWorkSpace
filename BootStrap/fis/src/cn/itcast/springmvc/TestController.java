package cn.itcast.springmvc;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




import cn.itcast.springmvc.model.Fund;
import cn.itcast.springmvc.model.FundUtil;
import cn.itcast.springmvc.model.User;

@Controller//用来标注当前类是springmvc的控制层的类
@RequestMapping("/test")//controller的唯一标识或者命名空间
public class TestController {
	

	/**
	 * 
	 * desc：直接在参数的列表上定义PrintWriter，out.write(result);把结果写到页面，建议使用的
	 * author:任亮
	 * mail:renliangjava@163.com
	 * qq群：2636378537
	 * 班级：0922
	 */
	@RequestMapping("/ajax.do")
	public void ajax1(String name, PrintWriter out){
		initFundData();
	    List<String> fundNames=FundUtil.recommed(funds, new User(Double.parseDouble(name.split(",")[0]), 
	    		Double.parseDouble(name.split(",")[1])),3);
		String result = "";
		for(String str:fundNames){
			result+=str+",";
		}
		out.write(result.substring(0, result.length()-1));
	}
	
	@RequestMapping("/toAjax.do")
	public String toAjax(){
		return "ajax";
	}	
	
	List<Fund> funds;
	public void initFundData(){
		funds = new ArrayList<Fund>();
	    Double[][] profitArray = new Double[][]{new Double[]{0.17,-2.38,0.27,0.85,-5.33,0.38,-5.41,3.57,-3.17,-2.46,2.55,0.99,0.48,-1.43,3.48,2.70,0.14,1.57,2.89,-0.26,3.52,4.21,5.82,6.93,-1.81,5.17,2.47,6.73,13.50,14.80},
	            new Double[]{0.90,-1.92,-1.31,6.75,-0.62,-2.00,1.14,1.26,1.99,1.22,-0.96,1.70,14.70,-0.89,-1.57,-1.37,-0.12,-5.75,-10.50,-2.60,-5.61,1.78,-4.96,-3.69,-0.26,1.11,-0.35,-1.07,-4.33,-0.19},
	            new Double[]{0.22,3.90,7.58,1.27,-3.76,-0.98,-9.40,1.96,-10.71,-1.75,3.97,3.43,2.94,-2.93,3.77,2.25,5.26,-2.91,5.50,-2.90,8.83,-4.68,4.40,3.83,-3.12,2.34,0.99,2.17,-3.36,5.91},
	            new Double[]{0.0,0.30,0.79,0.30,0.01,-0.01,-0.29,0.20,-0.49,0.69,-0.59,1.09,-0.68,2.36,-1.54,1.07,-1.06,0.59,-0.87,0.88,-0.68,-1.66,-1.99,-1.42,0.87,-1.13,-0.24,1.45,2.12,-0.83},
	            new Double[]{1.22,-0.84,0.96,-1.79,-0.88,0.33,-1.30,-1.86,-0.97,1.74,1.60,-1.26,0.85,-0.84,0.21,0.42,1.88,0.92,1.01,1.50,-1.08,5.38,7.47,7.83,4.49,-0.82,-3.32,1.97,1.30,2.25},
	            new Double[]{0.11,-1.70,0.51,1.36,-0.39,0.38,-0.71,-0.14,0.61,0.48,0.73,5.29,1.38,0.35,0.34,0.38,0.96,0.48,0.84,1.01,2.79,1.20,-2.92,-3.73,0.74,-1.13,-0.06,0.84,1.12,1.31},
	            new Double[]{3.42,0.49,0.29,0.88,0.0,0.19,0.19,0.58,0.48,0.48,0.38,0.28,0.28,0.38,0.56,-0.56,0.19,-1.23,0.40,0.60,0.79,0.29,-0.49,-0.69,0.04,0.92,-1.04,0.07,0.93,0.87},
	            new Double[]{2.01,-1.32,0.82,1.43,1.31,-1.19,0.80,0.40,-0.70,-0.20,0.20,3.90,-1.83,1.08,-1.07,7.94,-1.18,1.65,-1.45,2.66,1.07,3.36,-1.32,0.03,-1.21,-1.04,1.88,2.14,-0.97,1.45},
	            new Double[]{-1.90,-5.13,2.47,-2.25,3.57,-5.60,-3.36,12.04,-5.76,1.71,2.04,-2.18,1.98,11.45,-4.32,5.48,-3.01,2.50,-0.93,2.27,2.78,4.42,4.91,6.83,8.83,2.91,4.73,4.24,6.21,7.90},
	            new Double[]{-2.91,-5.51,2.30,2.91,-3.71,-3.03,4.11,3.81,-5.77,-0.84,1.97,1.65,-1.90,2.49,8.49,0.37,0.00,1.36,3.91,-1.18,-3.57,8.63,-2.49,9.42,-5.87,1.63,7.27,7.43,11.96,14.91}};
	    String[] fundNames=new String[]{"汇丰晋信大盘","上投摩根全球资源","海富通国策导向","嘉实绝对收益","博时裕益灵活配置",
	    		"天弘丰利债券","诺安稳固收益债券","博时天颐A","中证金融地产ETF","长盛沪深300"};
	    for (int i = 0; i < profitArray.length; i++)
	    {
	        List<Double> profits = new ArrayList<Double>();
	        for (int j = 0; j < profitArray[i].length; j++)
	        {
	            profits.add(profitArray[i][j]);
	        }
	        funds.add(new Fund("" + i, profits));
	    }
	}
}
