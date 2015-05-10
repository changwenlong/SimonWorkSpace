import java.util.*;

public class ScoreStatistic {
  
	public static Map<String,Integer> statistic(List<Score> scores) {
		Map<String,Integer> map=new HashMap<String, Integer>();
		Map<String,Integer> mapNum=new HashMap<String, Integer>();
		for(Score s:scores){
			if(map.get(s.classNumber)==null){
				map.put(s.classNumber, s.mark);
				mapNum.put(s.classNumber, 1);
			}else{
				map.put(s.classNumber, s.mark+map.get(s.classNumber));
				mapNum.put(s.classNumber, 1+mapNum.get(s.classNumber));
			}
		}
		for(String str:map.keySet()){
			map.put(str, map.get(str)/mapNum.get(str));
		}
		return map;
	}
	
	public static void main(String[] args){
		List<Score> list=new ArrayList<Score>();
		list.add(new Score("01",63));
		list.add(new Score("01",50));
		list.add(new Score("01",80));
		list.add(new Score("02",60));
		list.add(new Score("02",93));
		list.add(new Score("02",60));
		System.out.println(statistic(list));;
	}
}