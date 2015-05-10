package edu.zju.chwl.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;


public final class Directory {
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
	}
	
	public static class TreeInfo implements Iterable<File>{
		public List<File> files=new ArrayList<File>();
		public List<File> dirs=new ArrayList<File>();
		public Iterator<File> iterator() {
			return files.iterator();
		}
		public void addAll(TreeInfo other){
			this.files.addAll(other.files);
			this.dirs.addAll(other.dirs);
		}
		public String toString(){
			return String.format("files:%s\n dirs:%s", files.toString(),dirs.toString());
		}
	}
	
	public static TreeInfo walk(File dir,String regex){
		return recurseDirs(dir,regex);
	}

	private static TreeInfo recurseDirs(File dir, String regex) {
		TreeInfo result=new TreeInfo();
		for(File item:dir.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			}else{
				result.files.add(item);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(walk(new File("."),""));

	}

}
