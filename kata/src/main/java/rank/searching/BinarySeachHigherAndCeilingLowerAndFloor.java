package hackerRank.searching;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySeachHigherAndCeilingLowerAndFloor {

	@Test
	public void test(){
		assertEquals(Integer.valueOf(2), Integer.valueOf(binarySearch(new Integer[]{1,2,3},3)));
		assertEquals(Integer.valueOf(-3), Integer.valueOf(binarySearch(new Integer[]{1,2,3},4)));
		assertEquals(Integer.valueOf(-1), Integer.valueOf(binarySearch(new Integer[]{1,2,3},0)));
	}
	
	@Test
	public void test1(){
		assertEquals(Integer.valueOf(2), Integer.valueOf(higher(new Integer[]{1,2,3},2)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(higher(new Integer[]{1,2,3},1)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(higher(new Integer[]{1,2,3},0)));
	}
	
	@Test
	public void test2(){
		assertEquals(Integer.valueOf(0), Integer.valueOf(ceiling(new Integer[]{1,2,3},0)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(ceiling(new Integer[]{1,2,3},1)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(ceiling(new Integer[]{1,2,3},2)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(ceiling(new Integer[]{1,2,3},3)));
		assertEquals(Integer.valueOf(-1), Integer.valueOf(ceiling(new Integer[]{1,2,3},4)));
	}
	
	@Test
	public void test3(){
		assertEquals(Integer.valueOf(-1), Integer.valueOf(floor(new Integer[]{1,2,3},0)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(floor(new Integer[]{1,2,3},1)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(floor(new Integer[]{1,2,3},2)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(floor(new Integer[]{1,2,3},3)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(floor(new Integer[]{1,2,3},4)));
	}
	
	@Test
	public void test4(){
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lower(new Integer[]{1,2,3},1)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lower(new Integer[]{1,2,3},2)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lower(new Integer[]{1,2,3},3)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lower(new Integer[]{1,2,3},4)));
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] vector, T value){
		int lo = 0;
		int hi = vector.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if (vector[mid] == value){
				return mid;
			}else if(lo == hi){
				return -1 * (1+mid);
			}else if (vector[mid].compareTo(value) < 0){
				lo = mid+1;
			}else{
				hi =mid-1;
			}
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int higher(T[] vector, T value){
		int lo = 0;
		int hi = vector.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if (higher(vector[mid],value) && (mid ==0 || higherOrEqual(value,vector[mid-1]))){
				return mid;
			}else if (higherOrEqual(value, vector[mid])){
				lo = mid+1;
			}else{
				hi =mid-1;
			}
		}
		return -1;
	}
	
	private static <T extends Comparable<T>>  boolean higher(T t, T value) {
		return t.compareTo(value) > 0;
	}
	
	private static <T extends Comparable<T>>  boolean higherOrEqual(T t, T value) {
		return t.compareTo(value) >= 0;
	}
	
	private static <T extends Comparable<T>>  boolean lowerOrEqual(T t, T value) {
		return t.compareTo(value) <= 0;
	}
	
	private static <T extends Comparable<T>>  boolean lower(T t, T value) {
		return t.compareTo(value) < 0;
	}

	public static <T extends Comparable<T>> int ceiling(T[] vector, T value){
		int lo = 0;
		int hi = vector.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if (higherOrEqual(vector[mid],value) && (mid ==0 || higher(value, vector[mid-1]))){
				return mid;
			}else if (higher(value, vector[mid])){
				lo = mid+1;
			}else{
				hi =mid-1;
			}
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int floor(T[] vector, T value){
		int lo = 0;
		int hi = vector.length-1;
		int n = vector.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if (lowerOrEqual(vector[mid],value) && (mid == n || higher(vector[mid+1], value))){
				return mid;
			}else if (higher(value,vector[mid])){
				lo = mid+1;
			}else{
				hi =mid-1;
			}
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int lower(T[] vector, T value){
		int lo = 0;
		int hi = vector.length-1;
		int n = vector.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2;
			if (lower(vector[mid],value) && (mid == n || higherOrEqual(vector[mid+1], value))){
				return mid;
			}else if (higher(value,vector[mid])){
				lo = mid+1;
			}else{
				hi =mid-1;
			}
		}
		return -1;
	}
	
}
interface a {
	default void a(){}
}

interface b{
	default void a(){}
}

class c implements a,b{

	@Override
	public void a() {

	}
}


