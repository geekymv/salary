package com.heike.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Salary;
import com.heike.pojo.Student;


//参考博文：http://heisetoufa.iteye.com/blog/1932093

public class CreateExcel {

	public static InputStream getExcelInputStream(String[] titles,
			List<Salary> salarys, List<Recruit> recruits) {
		// 将OutputStream转化为InputStream
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		putDataOnOutputStream(titles, salarys, recruits, out);
		
		return new ByteArrayInputStream(out.toByteArray());
	}

	private static void putDataOnOutputStream(String[] titles,
			List<Salary> salarys, List<Recruit> recruits, OutputStream os) {
		try { 
			WritableWorkbook wworkbook = Workbook.createWorkbook(os);

			// 生成名为'第一页'的工作表，参数0表示这是第一页
			WritableSheet sheet = wworkbook.createSheet("学生补助报表", 0);

			// 合并单元格 //列 行
			sheet.mergeCells(0, 0, 8, 0);// 合并第一列第一行到第九列第一行的单元格

			// 设定行高
			sheet.setRowView(0, 400); // 设定第一行的高度为800
			// 设定列宽
			sheet.setColumnView(4, 15); // 设定第4列的宽度20
			sheet.setColumnView(5, 15); // 设定第5列的宽度20

			// 指定字体、字号和粗细
			WritableFont font = new WritableFont(WritableFont.TIMES, 12,
					WritableFont.BOLD);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE); // 水平居中
			format.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直居中

			// 在Label对象的构造函数中指明单元格的位置是第一行第一列，单元格的内容为
			Label label = new Label(0, 0, "安徽农业大学学生勤工助学工资表", format);
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);

			// 添加标题
			if (null != titles) {
				for (int i = 0; i < titles.length; i++) {
					label = new Label(i, 2, titles[i]); // 在第三行添加标题
					sheet.addCell(label);
				}
			}

			
			
			for(int i = 0; salarys != null && i < salarys.size(); i++) {
				
				List<String> datas = new ArrayList<String>();
				
				Salary s = salarys.get(i);
				
				Integer num = i + 1;	//编号
				
				Student student = s.getStudent();
				String stuName = student.getName();
				String stuNum = student.getNumber();
				String profession = student.getProfession();
				
				Recruit recruit = recruits.get(i);
				
				String postName = recruit.getPostName();	//岗位名称
				System.out.println(postName + "岗位名称");
				
				float salary = s.getSalary();	//基本工资
				float toolFee = s.getToolFee();	//工具费
				float bonus = s.getBonus();	//奖金
				
				//学院
				Employer employer = s.getEmployer();
				String empName = employer.getName();
				
				String remarks = s.getRemarks();	//备注
				
				datas.add(num+"");
				datas.add(stuName);
				datas.add(stuNum);
				datas.add(profession);
				datas.add(postName);
				datas.add("工作时间");
				datas.add(salary+"");
				datas.add(toolFee+"");
				datas.add(bonus+"");
				datas.add((salary+toolFee+bonus)+"");
				datas.add(empName);
				datas.add(remarks);
				
				for(int j = 0; j < datas.size(); j++){
					label = new Label(j, i+3, datas.get(j)); // 
					sheet.addCell(label);
				}
				
			}
			
			
			// 添加数据
			// for(int i = 0; i < datas.size(); i++){
			// //String是学院或社团的名字，List对应其中的数据
			// Map<String, List> map = datas.get(i);
			// Set<Map.Entry<String, List>> set = map.entrySet();
			//
			// for(Iterator<Map.Entry<String, List>> iter = set.iterator();
			// iter.hasNext();){
			// Map.Entry<String, List> entry = iter.next();
			//
			// String key = entry.getKey();
			// List values = entry.getValue(); //具体显示信息
			//
			// }
			//
			//
			// }

			// 生成一个保存数字的单元格，必须使用Number的完整路径，否则有语法歧义
			// jxl.write.Number number = new jxl.write.Number(0, 1, 21.10);

			// sheet.addCell(number);

			// 写入数据并关闭文件
			wworkbook.write();
			wworkbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
