/*
һ��ѧ����������
���ߣ�17320110 �迡��

*/

import java.util.Arrays;
import java.util.Scanner;

public class A1_stu{
public static void main(String[] args){
	 Scanner sc = new Scanner(System.in);
	 int i,j,n;
	 System.out.println("������Ҫͳ�Ƶ�ѧ������:");
	 n = sc.nextInt();
	 
	 Object[][] stu= new Object[n+1][2];   //��Object����ǿ������ת����int
	 int[] score = new int[n+1];			//�����ķ���
	 String[] name = new String[n+1];	//����������
	
	 System.out.println("������ѧ��:���� ����");
	 for(i=0;i<n;i++){
		 for(j=0;j<2;j++){			//j=0�����֣���j=1������
			 if(j==0)stu[i][j] = sc.next();else if(j==1)stu[i][j] = sc.nextInt();
		 }
		 score[i] = (int)stu[i][1];
	 }
	 Arrays.sort(score);				//��������
	 for(i=0;i<n;i++ ){							//��ά�������򣺶����֣������ֱ�����
		//System.out.println(score[n-i]);	 
		for(j=0; j<n; j++){
			if(score[n-i]==(int)stu[j][1])
			name[i] = (String)stu[j][0];
		}
	 }
	 System.out.println("\n  ���� ����");
	 for(i=0;i<n;i++){
			 System.out.println("  "+name[i]+"  "+score[n-i]);
	 }
	}
}