
/*
�塢����ת��

���ߣ�17320110 �迡��

1�� r����ת10���� ������Integer.parseInt((String) s,(int) radix)
2�� 10����ת2����	Integer.toBinaryString(n)
	10����ת8����	Integer.toOctalString(n)
	10����ת16����	Integer.toHexString(n)
	10����ת r ����	Integer.toString(100, 16)
*/

import java.util.Scanner;
public class A5_hexc {
	public static void main(String[] args){
		int s;
		do{
		Scanner sc = new Scanner(System.in);
		System.out.println("��Ҫת���Ľ��ƣ���������������2���˽�������8��");
		int choi = sc.nextInt();int tenHex ;
		System.out.println("����Ҫת��������");	
		String str = sc.next();
		
		tenHex = Integer.parseInt(str,choi);	//ת��ʮ����
		System.out.println("\n������:" + Integer.toBinaryString(tenHex));
		System.out.println("�˽���:" + Integer.toOctalString(tenHex));
		System.out.println("ʮ����:" + tenHex);
		System.out.println("ʮ������:" + Integer.toHexString(tenHex));
		System.out.println("\n1������");
		System.out.println("2���˳�");
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