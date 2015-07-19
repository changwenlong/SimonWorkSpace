package edu.zju.chwl.enumer;

public enum Blah {
	  A("text1"),//Singleton,an instance of Blah
	  B("text2"),
	  C("text3"),
	  D("text4");

	  private String text;

	  Blah(String text) {
	    this.text = text;
	  }

	  public String getText() {
	    return this.text;
	  }

	  public static Blah fromString(String text) {
	    if (text != null) {
	      for (Blah b : Blah.values()) {
	        if (text.equalsIgnoreCase(b.text)) {
	          return b;
	        }
	      }
	    }
	    return null;
	  }
	  
	  public static void main(String[] args){
		  System.out.println(Blah.fromString("text1"));
		  System.out.println(Blah.valueOf("A"));// String to enum
	  }
}
