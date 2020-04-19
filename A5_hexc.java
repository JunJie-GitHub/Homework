
/*
五、进制转换

作者：17320110 黎俊杰

1， r进制转10进制 方法：Integer.parseInt((String) s,(int) radix)
2， 10进制转2进制	Integer.toBinaryString(n)
	10进制转8进制	Integer.toOctalString(n)
	10进制转16进制	Integer.toHexString(n)
	10进制转 r 进制	Integer.toString(100, 16)
*/

import java.util.Scanner;
public class A5_hexc {
	public static void main(String[] args){
		int s;
		do{
		Scanner sc = new Scanner(System.in);
		System.out.println("你要转换的进制：（例：二进制输2，八进制输入8）");
		int choi = sc.nextInt();int tenHex ;
		System.out.println("输入要转换的数：");	
		String str = sc.next();
		
		tenHex = Integer.parseInt(str,choi);	//转成十进制
		System.out.println("\n二进制:" + Integer.toBinaryString(tenHex));
		System.out.println("八进制:" + Integer.toOctalString(tenHex));
		System.out.println("十进制:" + tenHex);
		System.out.println("十六进制:" + Integer.toHexString(tenHex));
		System.out.println("\n1、继续");
		System.out.println("2、退出");
		s = sc.nextInt();
		
		}while(s !=2);
		/*
		switch(choi){
			case 1:
				
			case 2:
			
			case 3:
			
			case 4:
			
			default:
		}
		*/
	}
}