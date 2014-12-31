package cn.itcast.springmvc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FundUtil {
	public static List<Fund> standardizationFund(List<Fund> fundDatas)
    {
        List<Double[]> datas = new ArrayList<Double[]>();
        datas.add(new Double[] { 1000.0, -1000.0 });
        datas.add(new Double[] { 1000.0, -1000.0 });
        datas.add(new Double[] { 1000.0, -1000.0 });
        for (Fund fundData:fundDatas)
        {
            Double average = fundData.getAverage();
            datas.get(0)[0] = getMin(datas.get(0)[0], average);
            datas.get(0)[1] = getMax(datas.get(0)[1], average);
            Double variance = fundData.getVariance();
            datas.get(1)[0] = getMin(datas.get(1)[0], variance);
            datas.get(1)[1] = getMax(datas.get(1)[1], variance);
            Double negativeAverage = fundData.getNegativeAverage();
            datas.get(2)[0] = getMin(datas.get(2)[0], negativeAverage);
            datas.get(2)[1] = getMax(datas.get(2)[1], negativeAverage);
        }
        for (Fund fundData : fundDatas)
        {
            fundData.standardization(datas);
        }
        return fundDatas;
    }

    static Double getMin(Double a, Double b)
    {
        return a < b ? a : b;
    }

    static Double getMax(Double a, Double b)
    {
        return a > b ? a : b;
    }

    public static List<String> recommed(List<Fund> fundDatas,User user,int recommedNum){
        standardizationFund(fundDatas);
        System.out.println("推荐指数如下:");
        for (Fund fundData : fundDatas)
        {
            fundData.setRecommedIndex(user.getItem1() * fundData.getAverage() +
                    user.getItem2() * fundData.getVariance() + user.getItem3() * fundData.getNegativeAverage());
            System.out.println(fundData.getFundName()+":"+ fundData.getRecommedIndex());
        }
        Collections.sort(fundDatas);
        List<String> fundNames = new ArrayList<String>();
        for (int i=0;i<recommedNum;i++)
        {
            fundNames.add(fundDatas.get(i).getFundName());
        }
        return fundNames;
    }
	
}
