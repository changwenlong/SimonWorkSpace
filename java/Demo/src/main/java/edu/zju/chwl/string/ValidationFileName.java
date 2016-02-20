package edu.zju.chwl.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationFileName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName="Sorp _MMIF -report.2015.xls   ";
		boolean flag=fileName.matches("[\\w|\\s.-]+");
		System.out.println(flag);

	}

}
