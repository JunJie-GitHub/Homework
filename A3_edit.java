/*
�����ı��༭��

���ߣ�17320110 �迡��

*/
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 

public class A3_edit {
	public static String content;
	public static File file;
	public static void main(String[] args){
	 /*
		GUI���洴��
	*/
	
	/*���ڿ��*/
	JFrame  frame = new JFrame("�ı��༭��");	// ���������ô���
	frame.pack();							// ��ʾ����
	frame.setBounds(300, 300, 800, 500);	//���ڵ�x,yλ�ã����ڴ�Сx,y,����.pack����
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//����Ĭ�ϵĹرմ���
	
	/*���*/
	JPanel panel = new JPanel();				//�����������
	//JScrollPane scrollPanel = new JScrollPane();	//���������ģ�����ˮƽ�ʹ�ֱ������������	
	frame.getContentPane().add(panel, BorderLayout.NORTH);
	JButton button = new JButton("��");
	JButton button_1 = new JButton("����");

	// �ɹ������
	JScrollPane scrollPane = new JScrollPane();
	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	JTextArea textArea = new JTextArea();		//�����ı�����
			
	// ����button(��)��ѡ��·��
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// ��ʾ�򿪵��ļ��Ի���
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(frame);
			try {
				// ʹ���ļ����ȡѡ����ѡ����ļ�
				file = jfc.getSelectedFile();
				
				//�ļ����ַ������
				content = readString(file);
				textArea.setText(content);
			} catch (Exception e2) {
				JPanel panel2 = new JPanel();
				JOptionPane.showMessageDialog(panel2, "û��ѡ���κ��ļ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	// ����button_1(����)��ѡ��·��
	button_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			JPanel panel3 = new JPanel();
			try {
				BufferedWriter bwriter = Files.newBufferedWriter(file.toPath());
				bwriter.write(textArea.getText());
				bwriter.close();
				//System.out.println(content);
				JOptionPane.showMessageDialog(panel3, "����ɹ�");
			} catch(Exception e2){
				JOptionPane.showMessageDialog(panel3, "����ʧ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
			}
			

		}
		
	});
	
	panel.add(button);
	panel.add(button_1);
	scrollPane.setViewportView(textArea);
	
	frame.setVisible(true);					//��÷����
	}
	
	/* ���ж�����Ҫ����ĸ�ʽ��������һ�ֶ�ȡ�ĺ÷�ʽ */
	private static String readString(File file)
	{
		int len=0;
		StringBuffer str=new StringBuffer("");
		try {
			FileInputStream is=new FileInputStream(file);
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader in= new BufferedReader(isr);
			String line=null;
			while( (line=in.readLine())!=null )
			{
			if(len != 0) // �����з�������
			{
				str.append("\r\n"+line);
			}
			else
			{
				str.append(line);
			}
			len++;
			}
			in.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}
	
}
