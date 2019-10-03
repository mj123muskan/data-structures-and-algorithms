package Stack;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import Stack.Main.LRUCache.Node;
class Main{
/*You are required to complete below class */
static class LRUCache {
    /*Inititalize an LRU cache with size N */
	Deque<Node> dq=new Deque<Main.LRUCache.Node>() {
		
		@Override
		public <T> T[] toArray(T[] arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(Collection<? extends Node> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public boolean removeLastOccurrence(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Node removeLast() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean removeFirstOccurrence(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Node removeFirst() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Node remove() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void push(Node e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Node pop() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node pollLast() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node pollFirst() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node poll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node peekLast() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node peekFirst() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node peek() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean offerLast(Node e) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean offerFirst(Node e) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean offer(Node e) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Iterator<Node> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node getLast() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node getFirst() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Node element() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterator<Node> descendingIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void addLast(Node e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addFirst(Node e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(Node e) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	 public static class Node
     {
         int k;
         int v;
     }
    public LRUCache(int N) {
    	Deque<>
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public static int get(int x) {
    }
    
    /*Sets the key x with value y in the LRU cache */
    public static void set(int x, int y) {
    }
} 
}
