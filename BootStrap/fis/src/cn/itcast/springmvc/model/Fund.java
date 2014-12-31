package cn.itcast.springmvc.model;

import java.util.Date;
import java.util.List;

public class Fund implements Comparable<Fund>{
		

	@Override
	public int compareTo(Fund o) {
		return o.getRecommedIndex().compareTo(this.recommedIndex);
	}

	public Fund(String fundName,List<Double> profits) {
        this.fundName = fundName;
        this.profits = profits;
        initFund();
    }

    String fundName;

    List<Double> profits;

    Double average;

    Double variance;

    Double negativeAverage;

    Double recommedIndex;

    //求平均值，方差，负平均值
    public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public List<Double> getProfits() {
		return profits;
	}

	public void setProfits(List<Double> profits) {
		this.profits = profits;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getVariance() {
		return variance;
	}

	public void setVariance(Double variance) {
		this.variance = variance;
	}

	public Double getNegativeAverage() {
		return negativeAverage;
	}

	public void setNegativeAverage(Double negativeAverage) {
		this.negativeAverage = negativeAverage;
	}

	public Double getRecommedIndex() {
		return recommedIndex;
	}

	public void setRecommedIndex(Double recommedIndex) {
		this.recommedIndex = recommedIndex;
	}

	void initFund(){
        Double sum = 0.0;
        Double sumNegative = 0.0;
        int size = 0;
        for (Double profit:profits)
        {
            sum += profit;
            if (profit < 0)
            {
                size++;
                sumNegative += profit;
            }
        }
        this.average = sum / profits.size();
        this.negativeAverage = sumNegative / size;
        this.variance = getVariance(profits,this.average);
    }

    //求方差
    Double getVariance(List<Double> datas, Double average)
    {
        Double sum = 0.0;
        for (Double data:datas)
        {
            sum += (data - average) * (data - average);
        }
        return sum / datas.size();
    }

    //标准化数据传参为{[min(平均值),max(平均值)],[min(方差),max(方差)],[min(负平均值),max(负平均值)]}
    public void standardization(List<Double[]> datas)
    {
        this.average = (this.average - datas.get(0)[0]) / (datas.get(0)[1] - datas.get(0)[0]) * 10;
        this.variance = 10 - (this.variance - datas.get(1)[0]) / (datas.get(1)[1] - datas.get(1)[0]) * 10;
        this.negativeAverage = (this.negativeAverage - datas.get(2)[0]) / (datas.get(2)[1] - datas.get(2)[0]) * 10;
    }
	
	

}
