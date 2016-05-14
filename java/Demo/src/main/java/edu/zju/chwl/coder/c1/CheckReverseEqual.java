package edu.zju.chwl.coder.c1;

/**
 * "waterbottle","erbottlewat"
 * x: wat
 * y: erbottle
 * "waterbottle":x+y
 * "erbottlewat":y+x
 * "waterbottle"+"waterbottle"一定包含"erbottlewat"
 * @author chwl
 * @Date 2016年5月11日 下午11:25:25
 */
public class CheckReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        return (s1+s1).contains(s2);
    }
}
