package edu.zju.chwl.clone;

import static org.junit.Assert.*;

import java.util.*;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneNumberTest {

	static PhoneNumber pn;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 pn=new PhoneNumber(716, 3574, 589);
	}

	@Test
	public void testClone() {
		System.out.println(pn);;
		System.out.println(pn.clone().toString());
	}
	
	@Test
	public void testTreeSet(){
		Set<PhoneNumber> set=new TreeSet<PhoneNumber>();
		set.add(pn);
		set.add(new PhoneNumber(716, 3574, 589));
		System.out.println(set);
		System.out.println(set.contains(pn));
	}
	
	@Test
	public void testHashSet(){
		Set<PhoneNumber> set=new HashSet<PhoneNumber>();
		set.add(pn);
		set.add(new PhoneNumber(716, 3574, 589));
		System.out.println(set);
		System.out.println(set.contains(pn));
	}

}
