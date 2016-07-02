package main.java;

import main.java.RPN.Operations;

public class Exponent extends Operations{

	@Override
	public Double calculate(Double operand1, Double operand2) throws Exception{
		boolean negativePower = false;
		if(operand1 != null && operand2 != null){
			if(operand2 < 0){
				negativePower = true;
				operand2 = Math.abs(operand2);
			} 
			double result = 1;
			for (int i=0; i< operand2; i++){
				result = result * operand1;
			}
			if(negativePower){
				result = 1/result;
			}
			return result;
		}
		return null;
	}
}
