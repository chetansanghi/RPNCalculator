package main.java;

import main.java.RPN.Operations;

//Class for division
//Class for Division Operation
public class Division extends Operations{

	@Override
	//This method is to calculate division of Double operand and here we go again...
	public Double calculate(Double operand1, Double operand2) throws Exception {
		
		if( operand1.equals(new Double(0.0))){
			throw new IllegalStateException("Dividend operator is ZERO.");
		}		

                //Finally rebase v/s pull making sense for history log
		
		if(operand1 != null && operand2 != null){
			return (operand2 / operand1);
		}
		return null;
	}
}
