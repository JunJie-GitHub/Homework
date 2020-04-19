/*
一、学生分数排序
作者：17320110 黎俊杰

*/

import java.util.Arrays;
import java.util.Scanner;

public class A1_stu{
public static void main(String[] args){
	 Scanner sc = new Scanner(System.in);
	 int i,j,n;
	 System.out.println("请输入要统计的学生人数:");
	 n = sc.nextInt();
	 
	 Object[][] stu= new Object[n+1][2];   //用Object可以强制类型转换成int
	 int[] score = new int[n+1];			//排序后的分数
	 String[] name = new String[n+1];	//排序后的名字
	
	 System.out.println("请输入学生:姓名 分数");
	 for(i=0;i<n;i++){
		 for(j=0;j<2;j++){			//j=0：名字，；j=1：分数
			 if(j==0)stu[i][j] = sc.next();else if(j==1)stu[i][j] = sc.nextInt();
		 }
		 score[i] = (int)stu[i][1];
	 }
	 Arrays.sort(score);				//降序排序
	 for(i=0;i<n;i++ ){							//二维数组排序：对名字，分数分别排序
		//System.out.println(score[n-i]);	 
		for(j=0; j<n; j++){
			if(score[n-i]==(int)stu[j][1])
			name[i] = (String)stu[j][0];
		}
	 }
	 System.out.println("\n  姓名 分数");
	 for(i=0;i<n;i++){
			 System.out.println("  "+name[i]+"  "+score[n-i]);
	 }
	}
}