package com.plchiang.linkedlist;

public class LinkedList<T extends Comparable> {
	private LLNode<T> head;
	
	public LinkedList() {
		head = null;
	}
	
	public LinkedList(T data) {
		head = new LLNode<T>(data);
	}
	
	public LLNode<T> head() {
		return head;
	}
	
	@Override
	public String toString() {
		String out = "";
		LLNode<T> walker = head;
		out += "[";
		if(head == null) {
			out += "]";
			return out;
		}
		while(walker.next() != null) {
			out += walker.toString() + ", ";
			walker = walker.next();
		}
		out += walker.toString() + "]";
		return out;
	}
	
	private LLNode<T> insertHead(LLNode<T> newHead) {
		if(head == null) {
			this.head = newHead;
		} else {
			LLNode<T> oldHead = this.head;
			this.head = newHead;
			this.head.setNext(oldHead);
		}
		return head;
	}
	
	public LLNode<T> insertHead(T newHead) {
		return insertHead(new LLNode<T>(newHead));
	}
	
	private LLNode<T> insertTail(LLNode<T> tail) {
		if(head == null) {
			insertHead(tail);
			return head;
		}
		LLNode<T> walker = head;
		while(walker.next() != null) {
			walker = walker.next();
		}
		walker.setNext(tail);
		return walker;
	}
	
	public LLNode<T> insertTail(T tail) {
		return insertTail(new LLNode<T>(tail));
	}
	
	public LLNode<T> find(T data) {
		if(head == null) {
			return null;
		}
		LLNode<T> walker = head;
		while(walker != null && walker.data() != data) {
			walker = walker.next();
		}
		if(walker == null) {
			return null;
		} else {
			return walker;
		}
	}
	
	public LLNode<T> delete(T data) {
		LLNode<T> finder = find(data);
		if(finder == null) {
			return null;
		} else if (finder == head) {
			head = head.next();
			finder.setNext(null);
		} else {
			LLNode<T> previous = head;
			while(previous.next() != finder) {
				previous = previous.next();
			}
			previous.setNext(finder.next());
			finder.setNext(null);
		}
		return finder;
	}
}

class LLNode<T extends Comparable> {
	private T data;
	private LLNode<T> next;
	
	public LLNode(T data) {
		this.data = data;
		next = null;
	}
	
	public LLNode(T data, LLNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public LLNode<T> next() {
		return next;
	}
	
	public void setNext(LLNode<T> next) {
		this.next = next;
	}
	
	public T data() {
		return data;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
}