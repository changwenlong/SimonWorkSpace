function addDay( dateValue,addDays )
{
    //创建开始时间对象
	var beginDate = new Date(dateValue);
	//设置增加的天数
	beginDate.setDate(beginDate.getDate() + addDays);

	//获取增加天数后的时间字串
	//-3- js中getMonth()的返回值从0开始到11，因此要加1，才是正确的值
	var endDateStr = beginDate.getFullYear() + "/" + (beginDate.getMonth()+1) + "/" + beginDate.getDate();
	return (endDateStr);
}

function getInterval( beginDateStr,endDateStr )
{
    //创建开始时间对象
	var beginDate = new Date(beginDateStr);
	var endDate = new Date(endDateStr);
	return ((endDate.getTime()-beginDate.getTime())/(1000*60*60*24) + 1);
}