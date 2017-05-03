package creativeproblems;

class Here implements AutoCloseable{

	@Override
	public void close(){
		System.out.println("EXECUTED");
		throw new RuntimeException();
		
	}}

public class WhatHappensWhenTryWithResourcesFinallyThrowsException {

	public static void main(String[] args){
		try(Here h1 = new Here(); Here h2 = new Here()){
			
		} 
	}
	
	
}
