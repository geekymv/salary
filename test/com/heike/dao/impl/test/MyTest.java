package com.heike.dao.impl.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	
	@Test
	public void testList() {
		
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("hello");
		set.add("java");
		
		List<String> list = new ArrayList<String>();
		
		list.addAll(set);
		
		System.out.println(list);
		
		

	}

}
