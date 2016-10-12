package edu.test_1;

public class Tester {

	public static void main(String[] args) {
		
				String[] fString = {"3x^2 -0x+1", "-2x^2 +8x -4", "5x^2+10x+5"};
				String[] domain = {"[-1.33,1.33]", "[-8.5,10.5]", "[-11,9]"};
				int[] n = {10, 15, 20};
						
				for(int i = 0; i< fString.length; i++){
					QuadraticFunction f = new QuadraticFunction(fString[i], domain[i], n[i]);
					double[] f_x = f.getFunVals();
					double[] xvals = f.getXVals();

				}

			}
		}
