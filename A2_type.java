/*
�������ֳ���

���ߣ�17320110 �迡��

1�����������(��ASCII��)
2���Ƚ�������ַ�����ȷ�ַ�����/��Ԫ����*100%
*/
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class A2_type{
public static void main(String[] args){
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	//int length = ran(2,10,2,10);  						//�����������2~10
	//System.out.println("�ַ���������ȣ�" + length);
	System.out.println("������Ҫ���ɵ��ַ����ȣ�");			//�ֶ������ַ�����
	int length = sc.nextInt();
	int rate = 0;										//�ַ���ȷ����
	char[] ch=new char[length];							//�û�������ַ�
	String str =new String();							//�û���������ڱȽϵ��ַ���
	int i;
	for(i=0;i<length;i++){
		ch[i] = (char)ran(33,63,96,126);
		}
	System.out.println("����������ַ�����" + toString(ch,length));
	do{
		System.out.println("������������ַ���");
		str=sc.next();
		
		if(str.length() != length) System.out.println("�ַ������Ȳ�ƥ�䣡��!  "+str.length()+" "+length);
	}while(str.length() != length);	
	
	for(i=0;i<length;i++){						//�Ƚ���ȷ��
		if(ch[i]==str.charAt(i))
		rate++;
	}
	System.out.println("��ȷ�ʣ�" + (float)rate/(float)length*100 +"%  r��ȷ�ַ�������"+rate);
		
}
	
/*------------------����----------------------*/
public static int ran(int min,int max ,int min_,int max_){		//���������(������������)
		//int max=63,max_=126;
        //int min=32,min_=96;     
        Random random = new Random();		//�����
		boolean b = random.nextBoolean();	//�������boolֵ
		if(b)
			return random.nextInt(max)%(max-min+1) + min;
		else
			return random.nextInt(max_)%(max_-min_+1) + min_;
	 }
public static String toString(char[] mychar,int length){		//char����תstring
		StringBuffer Buffer = new StringBuffer();
		for(int i=0;i<length;i++){
		Buffer.append(mychar[i]);
		}
		return Buffer.toString();
	}
	
}
