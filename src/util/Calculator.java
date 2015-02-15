package util;

public class Calculator {

	public static double[] cartesianToPolar(double x, double y)
	{
		double[] result = new double[2]; 
		result[0]=Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		result[1]=Math.atan(y/x);
		return result; //result[0]=radius, result[1]=angle
	}
	
	public static double[] polarToCartesian(double r, double theta)
	{
		//assume theta is in DEGREES
		double[] result = new double[2]; 
		double radians=Math.toRadians(theta); //convert angle into radians
		result[0]=r*Math.cos(radians);
		result[1]=r*Math.sin(radians);
		return result; //result[0]=x, result[1]=y
	}
	
	//all methods below intended for Cartesian coordinates!
	public static double[] add2vectors(double x1, double y1, double x2, double y2)
	{
		double[] result=new double[2];
		result[0]=x1+x2;
		result[1]=y1+y2;
		return result;
	}
	
	public static double[] add3vectors(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		double[] result=new double[2];
		result[0]=x1+x2+x3;
		result[1]=y1+y2+y3;
		return result;
	}
	
	public static double scalarProduct(double x1, double y1, double x2, double y2)
	{
		return x1*x2+y1*y2;
	}
	
	public static double vectorProduct(double x1, double x2, double y1, double y2)
	{
		return x1*y2-y1*x2; //this is just the value of the z component! so answer will be (0,0,z)!
	}
}