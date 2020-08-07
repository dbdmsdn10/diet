package test;

public class test {
public static void main(String[] args) {
	
	int f[2][44] = { { 1, 0 } , { 0, 1 } };
	for (int i = 2; i < 41; i++)
	{
		f[0][i] = f[0][i - 2] + f[0][i - 1];
		f[1][i] = f[1][i - 2] + f[1][i - 1];
	}
	int num;
}

}
