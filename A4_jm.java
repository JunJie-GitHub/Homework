/*
�ġ��ַ�������
���ߣ�17320110 �迡��

ע����֧������,�ո�
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A4_jm {
    public static void main(String []args) {
		String str_m = new String(); char[] m = new char[100]; //����
		String str_c = new String(); char[] c = new char[100]; //����
		String key = new String();  char[] k = new char[100];	//��Կ
		int int_k=0,int_m[] =new int[100];int[] int_c = new int[100]; 	//����charתint��������
		int i;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("1:ת������");
		System.out.println("2:ת������");
		System.out.println("3:Exit");
		String choi="0";		//String ��ֹ�û����������
		
		//while(choi != "1"&& choi!="2" &&choi!="3"){  //java�ﲻ��string���������Ƚ�
			while(!choi.equals("1")&& !choi.equals("2") &&!choi.equals("3")){
			
			choi = sc.next();
			switch(choi){
				case "1":
					//��������M
						System.out.println("����Ҫ���ܵ��ַ�����");
						str_m = sc.next();
						for(i=0;i<str_m.length();i++){
							m[i]=str_m.charAt(i);
						}
					//������Կ
					System.out.println("��������Կ��");
					key = sc.next();
					
					//ת������
						//��Կתint��ȡÿ���ַ���ASCII��ӣ�
					for(i=0;i<key.length();i++){
							k[i]=key.charAt(i);
							int_k=int_k+k[i];
					}
					//System.out.println("int_k��"+int_k);
						//���������int
					for(i=0;i<str_m.length();i++){
						int_c[i]=m[i]+int_k;
					}
						//����intתstr���(ȡstrÿ��λ����ASCII��)
					StringBuffer Buffer = new StringBuffer();
					Buffer.append(int_c[0]);
					for (i = 1; i < int_c.length; i++) {
						if(int_c[i]!=0)
						Buffer.append(int_c[i]);
					}
					str_c=Buffer.toString();	
					System.out.println("���ģ�"+str_c);
					break;
				case "2":
					//��������
						System.out.println("����Ҫ���ܵ����ģ�");
						str_c = sc.next();
						for(i=0;i<str_c.length();i++){
							c[i]=str_c.charAt(i);
						}
					//������Կ
					System.out.println("��������Կ��");
					key = sc1.next();
					//ת������
						//��Կתint��ȡÿ���ַ���ASCII��ӣ�
					for(i=0;i<key.length();i++){
							k[i]=key.charAt(i);
							int_k=int_k+k[i];
					}
					//System.out.println("int_k��"+int_k);
					String temp;
					int j=0;
					for(i=0;i<str_c.length(); i+=3){
						temp = str_c.substring(i, i+3); 
						int_c[j]=Integer.parseInt(temp);j++;
					}
					//System.out.println("int_c��"+Arrays.toString(int_c));

					//������
					for(i=0;i<j;i++){
						int_m[i]= int_c[i]-int_k;			//�õ�ASCII������
						m[i]=(char)int_m[i];
						//System.out.println("m��"+m[i]);		
					}
					str_m = new String(m);
					System.out.println("������ģ�"+str_m);
					break;
				
				case "3":
					break;
				default:
					System.out.println("��������ȷ����!");
			}
		}
		sc.close();	
    }
	
}