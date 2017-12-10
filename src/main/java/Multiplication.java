package main.java;

import main.java.RPN.Operations;

//Class for Multiplication Operation
public class Multiplication extends Operations{

	@Override
	//rebase
	//Method to multiplicate 2 given numbers
	public Double calculate(Double operand1, Double operand2) {
		if(operand1 != null && operand2 != null){
			return (operand1 * operand2);
		}
		return null;
	}
}
