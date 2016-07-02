package main.java;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import main.java.RPN.Operations;

public class RPNCalculator {
	
	public final static String ADDITION = "+";
	public final static String SUBTRACTION = "-";
	public final static String DIVISION = "/";
	public final static String MULTIPLICATION = "*";
	public static HashMap<String, Operations> operationMap = new HashMap<String, Operations>(); 
	static{
		operationMap.put("+", new Addition());
		operationMap.put("-", new Subtraction());
		operationMap.put("*", new Multiplication());
		operationMap.put("/", new Division());
		operationMap.put("^", new Exponent());
	}
//	public int calculateResult(String input){
//		Integer result = Integer.MIN_VALUE;
//		
//		if( input != null && input.length() == 0 ){
//			return result;
//		}
//		
//		Stack<String> inputStack = new Stack<String>();
//		StringTokenizer inputString = new StringTokenizer(input,",");
//		String curValue = null;
//		Integer firstValue;
//		Integer secondValue;
//		int opResult = -1;
//
//		while ( inputString.hasMoreTokens()){
//			curValue = inputString.nextToken();
//
//			switch ( curValue ){
//			case ADDITION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue + firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and ADDITION operator");
//				}
//				break;
//			case SUBTRACTION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue - firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and SUBTRACTION operator");
//				}
//				break;
//			case DIVISION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					if( firstValue.equals(new Integer(0))){
//						throw new IllegalStateException("Dividend operator is ZERO.");
//					}
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = (secondValue/firstValue);
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and DIVISION operator");
//				}
//				break;
//			case MULTIPLICATION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue * firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and MULTIPLICATION operator");
//				}
//				break;
//			default: 
//				inputStack.push(curValue);
//				break;
//
//			}
//
//		}
//		
//		
//		if( inputStack.size() == 1 ){
//			result = Integer.parseInt(inputStack.pop());	
//		}else{
//			throw new IllegalStateException("More than 2 values found which is not valid.");
//		}
//		
//		return result;
//	}

	public Double calculateResult(String input) throws Exception{
		Double result = Double.MIN_VALUE;
		
		if( input != null && input.length() == 0 ){
			return result;
		}
		
		Stack<String> inputStack = new Stack<String>();
		StringTokenizer inputString = new StringTokenizer(input,",");
		String curValue = null;
		Double firstValue;
		Double secondValue;

		while ( inputString.hasMoreTokens()){
			curValue = inputString.nextToken();
			Set<String> operatations = operationMap.keySet();
			if( operatations.contains(curValue)){
				Operations operation = null;
				if( inputStack.size() >= 2){
					operation = operationMap.get(curValue);
					firstValue = Double.parseDouble(inputStack.pop());
					secondValue = Double.parseDouble(inputStack.pop());
					Double value = operation.calculate(firstValue, secondValue);
					inputStack.push(String.valueOf(value));
				}else{
					throw new IllegalStateException("Invalid Operation");
				}				
			}else{
				inputStack.push(curValue);
			}
			
//			switch ( curValue ){
//			case ADDITION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue + firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and ADDITION operator");
//				}
//				break;
//			case SUBTRACTION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue - firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and SUBTRACTION operator");
//				}
//				break;
//			case DIVISION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					if( firstValue.equals(new Integer(0))){
//						throw new IllegalStateException("Dividend operator is ZERO.");
//					}
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = (secondValue/firstValue);
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and DIVISION operator");
//				}
//				break;
//			case MULTIPLICATION:
//				if( inputStack.size() >= 2 ){
//					firstValue = Integer.parseInt(inputStack.pop());
//					secondValue = Integer.parseInt(inputStack.pop());
//					opResult = secondValue * firstValue;
//					inputStack.push(String.valueOf(opResult));
//				}else{
//					throw new IllegalStateException("Only one value and MULTIPLICATION operator");
//				}
//				break;
//			default: 
//				inputStack.push(curValue);
//				break;
//
//			}

		}
		
		
		if( inputStack.size() == 1 ){
			result = Double.parseDouble(inputStack.pop());	
		}else{
			throw new IllegalStateException("More than 2 values found which is not valid.");
		}
		
		return result;
	}
}
