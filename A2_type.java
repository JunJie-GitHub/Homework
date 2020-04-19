/*
二、打字程序

作者：17320110 黎俊杰

1，生成随机数(做ASCII码)
2，比较输入的字符，正确字符个数/总元素数*100%
*/
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class A2_type{
public static void main(String[] args){
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	//int length = ran(2,10,2,10);  						//随机产生长度2~10
	//System.out.println("字符串随机长度：" + length);
	System.out.println("请输入要生成的字符长度：");			//手动输入字符长度
	int length = sc.nextInt();
	int rate = 0;										//字符正确个数
	char[] ch=new char[length];							//用户输入的字符
	String str =new String();							//用户输入的用于比较的字符串
	int i;
	for(i=0;i<length;i++){
		ch[i] = (char)ran(33,63,96,126);
		}
	System.out.println("产生的随机字符串：" + toString(ch,length));
	do{
		System.out.println("请输入产生的字符串");
		str=sc.next();
		
		if(str.length() != length) System.out.println("字符串长度不匹配！！!  "+str.length()+" "+length);
	}while(str.length() != length);	
	
	for(i=0;i<length;i++){						//比较正确率
		if(ch[i]==str.charAt(i))
		rate++;
	}
	System.out.println("正确率：" + (float)rate/(float)length*100 +"%  r正确字符个数："+rate);
		
}
	
/*------------------方法----------------------*/
public static int ran(int min,int max ,int min_,int max_){		//产生随机数(两个闭区间内)
		//int max=63,max_=126;
        //int min=32,min_=96;     
        Random random = new Random();		//随机数
		boolean b = random.nextBoolean();	//生成随机bool值
		if(b)
			return random.nextInt(max)%(max-min+1) + min;
		else
			return random.nextInt(max_)%(max_-min_+1) + min_;
	 }
public static String toString(char[] mychar,int length){		//char数组转string
		StringBuffer Buffer = new StringBuffer();
		for(int i=0;i<length;i++){
		Buffer.append(mychar[i]);
		}
		return Buffer.toString();
	}
	
}
