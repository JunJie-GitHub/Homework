/*
四、字符串加密
作者：17320110 黎俊杰

注：不支持中文,空格
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A4_jm {
    public static void main(String []args) {
		String str_m = new String(); char[] m = new char[100]; //明文
		String str_c = new String(); char[] c = new char[100]; //密文
		String key = new String();  char[] k = new char[100];	//密钥
		int int_k=0,int_m[] =new int[100];int[] int_c = new int[100]; 	//用于char转int，来计算
		int i;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("1:转换明文");
		System.out.println("2:转换密文");
		System.out.println("3:Exit");
		String choi="0";		//String 防止用户输入非数字
		
		//while(choi != "1"&& choi!="2" &&choi!="3"){  //java里不能string不能这样比较
			while(!choi.equals("1")&& !choi.equals("2") &&!choi.equals("3")){
			
			choi = sc.next();
			switch(choi){
				case "1":
					//输入明文M
						System.out.println("输入要加密的字符串：");
						str_m = sc.next();
						for(i=0;i<str_m.length();i++){
							m[i]=str_m.charAt(i);
						}
					//设置密钥
					System.out.println("请设置密钥：");
					key = sc.next();
					
					//转换密文
						//密钥转int（取每个字符的ASCII相加）
					for(i=0;i<key.length();i++){
							k[i]=key.charAt(i);
							int_k=int_k+k[i];
					}
					//System.out.println("int_k："+int_k);
						//计算出密文int
					for(i=0;i<str_m.length();i++){
						int_c[i]=m[i]+int_k;
					}
						//密文int转str输出(取str每两位数的ASCII码)
					StringBuffer Buffer = new StringBuffer();
					Buffer.append(int_c[0]);
					for (i = 1; i < int_c.length; i++) {
						if(int_c[i]!=0)
						Buffer.append(int_c[i]);
					}
					str_c=Buffer.toString();	
					System.out.println("密文："+str_c);
					break;
				case "2":
					//输入密文
						System.out.println("输入要解密的密文：");
						str_c = sc.next();
						for(i=0;i<str_c.length();i++){
							c[i]=str_c.charAt(i);
						}
					//输入密钥
					System.out.println("请输入密钥：");
					key = sc1.next();
					//转换密文
						//密钥转int（取每个字符的ASCII相加）
					for(i=0;i<key.length();i++){
							k[i]=key.charAt(i);
							int_k=int_k+k[i];
					}
					//System.out.println("int_k："+int_k);
					String temp;
					int j=0;
					for(i=0;i<str_c.length(); i+=3){
						temp = str_c.substring(i, i+3); 
						int_c[j]=Integer.parseInt(temp);j++;
					}
					//System.out.println("int_c："+Arrays.toString(int_c));

					//解密文
					for(i=0;i<j;i++){
						int_m[i]= int_c[i]-int_k;			//得到ASCII码数组
						m[i]=(char)int_m[i];
						//System.out.println("m："+m[i]);		
					}
					str_m = new String(m);
					System.out.println("解得明文："+str_m);
					break;
				
				case "3":
					break;
				default:
					System.out.println("请输入正确数字!");
			}
		}
		sc.close();	
    }
	
}