/*
三、文本编辑器

作者：17320110 黎俊杰

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
		GUI界面创建
	*/
	
	/*窗口框架*/
	JFrame  frame = new JFrame("文本编辑器");	// 创建及设置窗口
	frame.pack();							// 显示窗口
	frame.setBounds(300, 300, 800, 500);	//窗口的x,y位置，窗口大小x,y,放在.pack后面
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//设置默认的关闭窗口
	
	/*面板*/
	JPanel panel = new JPanel();				//创建面板容器
	//JScrollPane scrollPanel = new JScrollPane();	//带滚动条的，可以水平和垂直滚动的面板组件	
	frame.getContentPane().add(panel, BorderLayout.NORTH);
	JButton button = new JButton("打开");
	JButton button_1 = new JButton("保存");

	// 可滚动面板
	JScrollPane scrollPane = new JScrollPane();
	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	JTextArea textArea = new JTextArea();		//创建文本区域
			
	// 监听button(打开)的选择路径
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 显示打开的文件对话框
			JFileChooser jfc = new JFileChooser();
			jfc.showSaveDialog(frame);
			try {
				// 使用文件类获取选择器选择的文件
				file = jfc.getSelectedFile();
				
				//文件的字符串输出
				content = readString(file);
				textArea.setText(content);
			} catch (Exception e2) {
				JPanel panel2 = new JPanel();
				JOptionPane.showMessageDialog(panel2, "没有选中任何文件", "提示", JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	// 监听button_1(保存)的选择路径
	button_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			JPanel panel3 = new JPanel();
			try {
				BufferedWriter bwriter = Files.newBufferedWriter(file.toPath());
				bwriter.write(textArea.getText());
				bwriter.close();
				//System.out.println(content);
				JOptionPane.showMessageDialog(panel3, "保存成功");
			} catch(Exception e2){
				JOptionPane.showMessageDialog(panel3, "保存失败", "提示", JOptionPane.WARNING_MESSAGE);
			}
			

		}
		
	});
	
	panel.add(button);
	panel.add(button_1);
	scrollPane.setViewportView(textArea);
	
	frame.setVisible(true);					//最好放最后
	}
	
	/* 按行读对于要处理的格式化数据是一种读取的好方式 */
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
			if(len != 0) // 处理换行符的问题
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
