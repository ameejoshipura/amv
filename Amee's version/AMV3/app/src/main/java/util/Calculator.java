package util;

/**
 * Created by Amee on 2015-02-22.
 */
public class Calculator {

    public static double[] polarToCartesian(double r, double t) throws Exception{
        if (Math.abs(r)>=10000 || Math.abs(t)>=10000)
        {
            throw new Exception("Inputs too large!");
        }
        double[] result = new double[2];
        result[0] = r*Math.cos(t);
        result[1] = r*Math.sin(t);
        return result;
    }

    public static double[] cartesianToPolar(double x, double y) throws Exception{
        if (x==0 || y==0)
        {
            throw new Exception("One or more inputs are zero!");
        }

        else if (Math.abs(x)>=10000 || Math.abs(y)>=10000)
        {
            throw new Exception("Inputs too large!");
        }

        else if (Math.abs(x)<=0.01 || Math.abs(y)<=0.01)
        {
            throw new Exception("Inputs too small!");
        }
        double[] result = new double[2];
        result[0] = Math.sqrt((x*x)+(y*y));
        result[1] = Math.atan(y/x);
        return result;
    }

    public static double[] add2Vectors(double x1, double y1, double x2, double y2) throws Exception{
        if (Math.abs(x1)>=10000 || Math.abs(y1)>=10000 || Math.abs(x2)>=10000 || Math.abs(y2)>=10000)
        {
            throw new Exception("Inputs too large!");
        }
        double[] result = new double[2];
        result[0] = x1 + x2;
        result[1] = y1 + y2;
        return result;
    }

    public static double[] add3Vectors(double x1, double y1, double x2, double y2, double x3, double y3) throws Exception{
        if (Math.abs(x1)>=10000 || Math.abs(y1)>=10000 || Math.abs(x2)>=10000 || Math.abs(y2)>=10000 ||
                Math.abs(x3)>=10000 || Math.abs(y3)>=10000)
        {
            throw new Exception("Inputs too large!");
        }
        double[] result = new double[2];
        result[0] = x1 + x2 + x3;
        result[1] = y1 + y2 + y3;
        return result;
    }

    public static double scalarProduct(double x1, double y1, double x2, double y2) throws Exception{
        if (Math.abs(x1)>=10000 || Math.abs(y1)>=10000 || Math.abs(x2)>=10000 || Math.abs(y2)>=10000)
        {
            throw new Exception("Inputs too large!");
        }
        return ((x1*x2)+(y1*y2));
    }

    public static double vectorProduct(double x1, double y1, double x2, double y2) throws Exception{
        if (Math.abs(x1)>=10000 || Math.abs(y1)>=10000 || Math.abs(x2)>=10000 || Math.abs(y2)>=10000)
        {
            throw new Exception("Inputs too large!");
        }
        return ((x1*y2)-(x2*y1));
    }
}
