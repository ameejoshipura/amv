package tests;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import util.Calculator;

public class CalculatorTests{

	@Test 
	public void cToP_returns_double_array() throws Exception
	{
		double[] result=Calculator.cartesianToPolar(3,4);
		Assert.assertNotNull(result);
		
	}
	
	@Test 
	public void cToP_inputs_are_zero() throws Exception
	{
		boolean thrown = false;
		try {
		    Calculator.cartesianToPolar(0,0);
		  } catch (Exception e) {
		    thrown = true;
		  }

		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void cToP_inputs_are_nonzero() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.cartesianToPolar(3.0,4.0);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(result[0]==5 && (Math.abs(result[1]-Math.atan(4.0/3.0))<0.1));
	}
	
	@Test 
	public void cToP_contains_negative_input() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.cartesianToPolar(3.0,-4.0);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(result[0]==5 && (Math.abs(result[1]-Math.atan(-4.0/3.0))<0.1));
	}
	
	@Test 
	public void cToP_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.cartesianToPolar(10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void cToP_inputs_too_small() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.cartesianToPolar(0.01,0.01);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void pToC_returns_double_array() throws Exception
	{
		double[] result=Calculator.polarToCartesian(3,0.5);
		Assert.assertNotNull(result);
		
	}
	
	@Test 
	public void pToC_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.polarToCartesian(10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void pToC_inputs_are_nonzero() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.polarToCartesian(5,Math.atan(4.0/3.0));
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(Math.abs(3-result[0])<0.01 && Math.abs(4-result[1])<0.01);
	}
	
	@Test 
	public void add2vectors_returns_double_array() throws Exception
	{
		double[] result=Calculator.add2vectors(3,4,5,6);
		Assert.assertNotNull(result);
	}
	
	@Test 
	public void add2vectors_regular_input() throws Exception
	{
		double[] result=Calculator.add2vectors(3,4,5,6);
		Assert.assertTrue(result[0]==8 && result[1]==10);
	}
	
	@Test 
	public void add2vectors_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.add2vectors(10000,-10000,10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void add3vectors_returns_double_array() throws Exception
	{
		double[] result=Calculator.add3vectors(3,4,5,6,7,8);
		Assert.assertNotNull(result);
	}
	
	@Test 
	public void add3vectors_regular_input() throws Exception
	{
		double[] result=Calculator.add3vectors(3,4,5,6,7,8);
		Assert.assertTrue(result[0]==15 && result[1]==18);
	}
	
	@Test 
	public void add3vectors_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double[] result={-1,-1};
		try {
		    result = Calculator.add3vectors(10000,-10000,10000,-10000,10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void scalarProduct_regular_input() throws Exception
	{
		double result=Calculator.scalarProduct(3,4,5,6);
		Assert.assertTrue(result == 3*5+4*6);
	}
	
	@Test 
	public void scalarProduct_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double result=-1;
		try {
		    result = Calculator.scalarProduct(10000,-10000,10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
	@Test 
	public void vectorProduct_regular_input() throws Exception
	{
		double result=Calculator.vectorProduct(3,4,5,6);
		Assert.assertTrue(result == 3*6-4*5);
	}
	
	@Test 
	public void vectorProduct_inputs_too_large() throws Exception
	{
		boolean thrown = false;
		double result=-1;
		try {
		    result = Calculator.vectorProduct(10000,-10000,10000,-10000);
		  } catch (Exception e) {
		    thrown = true;
		  }
		
		  Assert.assertTrue(thrown);
	}
	
}
