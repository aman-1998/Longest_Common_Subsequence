import java.util.*;
import java.lang.*;
import java.io.*;

class LCS
{
	int lcs(String str1,String str2)
	{
		int i,j;
		char[] X=new char[str1.length()+1];
		char[] Y=new char[str2.length()+1];
		for(i=1;i<=X.length-1;i++)
			X[i]=str1.charAt(i-1);
		for(i=1;i<=Y.length-1;i++)
			Y[i]=str2.charAt(i-1);
		int[][] C=new int[str1.length()+1][str2.length()+1];
		for(i=0;i<=str2.length();i++)
			C[0][i]=0;
		for(i=0;i<=str1.length();i++)
			C[i][0]=0;
		for(i=1;i<=X.length-1;i++)
		{
			for(j=1;j<=Y.length-1;j++)
			{
				if(X[i]==Y[j])
					C[i][j]=C[i-1][j-1]+1;
				else
					C[i][j]=C[i-1][j]>C[i][j-1]?C[i-1][j]:C[i][j-1];
			}
		}
		i=str1.length();
		j=str2.length();
		StringBuffer sb=new StringBuffer();
		while(i!=0 && j!=0)
		{
			if(X[i]==Y[j])
			{
				sb.append(X[i]);
				i--;
				j--;
			}
			else
			{
				if(C[i-1][j]>C[i][j-1])
					i--;
				else
					j--;
			}
		}
		sb.reverse();
		System.out.println("\nLCS = "+sb);
		return C[str1.length()][str2.length()];
	}
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter string 1 : ");
		String str1=in.nextLine();
		System.out.print("Enter string 2 : ");
		String str2=in.nextLine();
		LCS x=new LCS();
		int L=x.lcs(str1,str2);
		System.out.print("\nLength of longest common subsequence = "+L+"\n");
	}
}