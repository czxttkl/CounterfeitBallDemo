package com.czxttkl.balltree;

public class Leaf implements Node{
	public int counterfeit_ball;
	public String weight;
	
	public Leaf() {
		
	}
	
	public Leaf(int ball, String weight) {
		this.counterfeit_ball = ball;
		this.weight = weight;
	}
}