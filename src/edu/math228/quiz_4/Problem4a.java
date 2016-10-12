package edu.math228.quiz_4;
public class Problem4a {

	public static void main(String[] args) {
		System.out.println(findRecursively(8));
		System.out.println(findIteratively(8));
	}
	
	public static int findRecursively(int n){
		if (n==0){return 1;}
		else if (n==1){return 2;}
		else return findRecursively(n-1)*findRecursively(n-2);
	}
	
	public static int findIteratively(int n){
		int first = 1;
		int second = 2;
		int temp;
		if (n==0){return first;}
		else if(n==1){return second;}
		else{
			for(int i = 0; i<n; i++){
				temp = second;
				second = second*first;
				first = temp;
			}
			return first;
		}
	}

}
