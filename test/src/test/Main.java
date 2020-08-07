package test;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int[][] a = new int[2][41];
		a[0][0]=1; 
		a[0][1]=0; 
		a[1][0]=0;
		a[1][1]=1;
		for(int i=2;i<41;i++)
		{
			a[0][i]=a[0][i-1]+a[0][i-2];
			a[1][i]=a[1][i-1]+a[1][i-2];
		}
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i=0;i<num;i++)
		{
			int b = scan.nextInt();
			System.out.println(a[0][b]+" "+a[1][b]);
		}
		
	}
}
