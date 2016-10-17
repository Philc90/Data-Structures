package com.plchiang.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.plchiang.linkedlist.LinkedList;

public class LinkedListTester {
	LinkedList<Integer> ll;
	
	@Before
	public void setup() {
		System.out.println("Linked List Test");
		ll = new LinkedList<>();
	}
	
	@Test
	public void testInsertHead() {
		ll.insertHead(1);
		Assert.assertEquals(ll.head().data(), new Integer(1));
		ll.insertHead(0);
		Assert.assertEquals(ll.head().data(), new Integer(0));
	}
	
	@Test
	public void testInsertTail() {
		ll.insertTail(0);
		Assert.assertEquals(ll.head().data(), new Integer(0));
		ll.insertTail(1);
		Assert.assertEquals(ll.find(1).data(), new Integer(1));
	}
	
	@Test
	public void testFind() {
		ll.insertTail(0);
		Assert.assertNotNull(ll.find(0));
		Assert.assertNull(ll.find(100));
	}
	
	public void testDelete() {
		ll.insertTail(0);
		ll.insertTail(1);
		ll.insertTail(2);
		Assert.assertNotNull(ll.delete(2));
		Assert.assertNotNull(ll.delete(1));
		Assert.assertNotNull(ll.delete(0));
		Assert.assertNull(ll.head());
	}

}
