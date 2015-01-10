package com.juan.vectorcalc;

public class Operator {
	//+ = 1
	//- = 2
	//. = 3
	//x = 4
	int operator;

	public Operator(int operator) {
		this.operator = operator;
	}
	
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}
	
	public Operator clone(){
		Operator clone = new Operator(this.operator);
		return clone;
	}
}
