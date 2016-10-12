package edu.test_1;
public class QuadraticFunction {
	private String function;
	private String domain;
	private int numPartitions;
	private double[] xValues; // like the value of the partition, adding the
								// partitions as you go
	private double[] functionValues; // evaluates the function based on the
										// values from the other array

	public QuadraticFunction() {
		this.function = "X";
		this.domain = "[0,1]";
		this.numPartitions = 2;
		xValues = new double[2];
		functionValues = new double[2];
	}

	public QuadraticFunction(String function, String domain, int numPartitions) {
		try {
			this.function = function;
		} catch (RuntimeException e) {
			System.out.println("Incorrect function formatt");
		}
		try {
			this.domain = domain;
		} catch (RuntimeException e) {
			System.out.println("Domain should be given in the format [A,B] where A and B are real numbers");
		}
		this.numPartitions = numPartitions;
		
		xValues = new double[numPartitions+1];
		domain = domain.substring(1,domain.length()-1);
		String test[] = domain.split(",");
		for(int i = 0; i<xValues.length; i++){
			double start = Double.parseDouble(test[0]);
			double end = Double.parseDouble(test[1]);
			double dx = (end - start)/numPartitions;
			xValues[i] = start + i*dx;
		}
		functionValues = new double[numPartitions+1];
		for(int j = 0; j<functionValues.length; j++){
			double X = xValues[j];
			String testing[] = function.split("([x])");
			functionValues[j] = Double.parseDouble(testing[0])*Math.pow(X, 2) + Double.parseDouble(testing[2]);
			testing = testing[1].split(" ");
			functionValues[j] += Double.parseDouble(testing[1])*X;
		}
	}
	
	public double[] getFunVals(){
		return this.functionValues;
	}
	
	public double[] getXVals(){
		return this.xValues;
	}
	
	public void helper(){
		for(int i=0; i<xValues.length; i++){
			System.out.println(xValues[i]);
	}
		System.out.println("----");

		for(int i=0; i<functionValues.length; i++){
			System.out.println(functionValues[i]);
	}
	}

}
