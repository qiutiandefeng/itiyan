package com.yfhl.util;

import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yfhl.entity.Model;
import com.yfhl.entity.User;

/**
 * 
 * 导出表格工具类
 * 
 * @author luans
 *
 */
public class OutExcelSynthesize {

	/**
	 *  导出普通用户Excel
	 * @param os
	 * @param list
	 * @param fname
	 * @throws Exception
	 * @author luans
	 */
	public void createsingleExcel(OutputStream os, List<User> list, String fname)
			throws Exception {
		WritableFont fontTitle = new WritableFont(WritableFont.TIMES, 9,
				WritableFont.NO_BOLD);
		fontTitle.setColour(jxl.format.Colour.RED);
		WritableCellFormat formatTitle = new WritableCellFormat(fontTitle);
		formatTitle.setWrap(true);
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);

		// fname = new String(fname.getBytes("ISO-8859-1"), "utf-8");
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet(fname, 0);

		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		// 创建第一行
		Label from = new Label(0, 0, "来源");
		sheet.addCell(from);
		Label id = new Label(1, 0, "用户编号");
		sheet.addCell(id);
		Label name = new Label(2, 0, "用户名");
		sheet.addCell(name);
		Label email = new Label(3, 0, "邮箱");
		sheet.addCell(email);
		Label phone = new Label(4, 0, "电话");
		sheet.addCell(phone);
		Label realname = new Label(5, 0, "真实姓名");
		sheet.addCell(realname);
		Label address = new Label(6, 0, "所在地");
		sheet.addCell(address);
		User user = new User();
		String fromtext = "微信";
		// 标题下的内容
		for (int i = 0; i < list.size(); i++) {// 行
			user = list.get(i);
			if (user.getWxOpenid() == null || "".equals(user.getWxpOpenid())) {
				fromtext = "平台";
			} else {
				fromtext = "微信";
			}
			Label from2 = new Label(0, i + 1, fromtext);
			sheet.addCell(from2);
			Label id2 = new Label(1, i + 1, user.getUid() + "");
			sheet.addCell(id2);
			Label name2 = new Label(2, i + 1, user.getUsername());
			sheet.addCell(name2);
			Label email2 = new Label(3, i + 1, user.getEmail());
			sheet.addCell(email2);
			Label phone2 = new Label(4, i + 1, user.getPhone());
			sheet.addCell(phone2);
			Label realname2 = new Label(5, i + 1, user.getRealname());
			sheet.addCell(realname2);
			Label address2 = new Label(6, i + 1, user.getAddress());
			sheet.addCell(address2);

		}

		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

	/**
	 * 导出商品信息 
	 * @author luans
	 */
	public void outModelExcel(OutputStream os, List<Model> list)
			throws Exception {
		WritableFont fontTitle = new WritableFont(WritableFont.TIMES, 9,
				WritableFont.NO_BOLD);
		fontTitle.setColour(jxl.format.Colour.RED);
		WritableCellFormat formatTitle = new WritableCellFormat(fontTitle);
		formatTitle.setWrap(true);
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);

		// fname = new String(fname.getBytes("ISO-8859-1"), "utf-8");
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("商品信息", 0);

		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		// 创建第一行
		Label no = new Label(0, 0, "商品编号");
		sheet.addCell(no);
		Label name = new Label(1, 0, "商品名称");
		sheet.addCell(name);
		Label author = new Label(2, 0, "设计师");
		sheet.addCell(author);
		Label brand = new Label(3, 0, "品牌");
		sheet.addCell(brand);
		Label category = new Label(4, 0, "类别");
		sheet.addCell(category);
		Label modRepertory = new Label(5, 0, "库存");
		sheet.addCell(modRepertory);
		Label modVisitcount = new Label(6, 0, "浏览数");
		sheet.addCell(modVisitcount);
		Label modShoppingcount = new Label(7, 0, "购物车");
		sheet.addCell(modShoppingcount);
		Label recommend = new Label(8, 0, "推荐");
		sheet.addCell(recommend);
		Label status = new Label(9, 0, "状态");
		sheet.addCell(status);
		Model model = new Model();
		String recommend_text = "推荐";
		String status_text = "审核中";
		// 标题下的内容
		for (int i = 0; i < list.size(); i++) {// 行
			model = list.get(i);

			Label no2 = new Label(0, i + 1, model.getMid() + "");
			sheet.addCell(no2);
			Label name2 = new Label(1, i + 1, model.getTitle());
			sheet.addCell(name2);
			Label author2 = new Label(2, i + 1, model.getDesignerName());
			sheet.addCell(author2);
			Label brand2 = new Label(3, i + 1, model.getBrand());
			sheet.addCell(brand2);
			Label category2 = new Label(4, i + 1, model.getCategoryName());
			sheet.addCell(category2);
			Label modRepertory2 = new Label(5, i + 1, model.getModRepertory()
					+ "");
			sheet.addCell(modRepertory2);
			Label modVisitcount2 = new Label(6, i + 1, model.getModVisitcount()
					+ "");
			sheet.addCell(modVisitcount2);
			Label modShoppingcount2 = new Label(7, i + 1,
					model.getModShoppingcount() + "");
			sheet.addCell(modShoppingcount2);
            if(model.getRecommend()==1){
            	recommend_text="推荐";
            }else if(model.getRecommend()==2){
            	recommend_text="不推荐";
            }
			Label recommend2 = new Label(8, i + 1, recommend_text);
			sheet.addCell(recommend2);
			if (model.getStatus() == 1) {
				status_text = "审核中";
			} else if (model.getStatus() == 2) {
				status_text = "展示中";
			} else if (model.getStatus() == 3) {
				status_text = "已下架";
			} else if (model.getStatus() == 4) {
				status_text = "暂不出售";
			}
			Label status2 = new Label(9, i + 1, status_text);
			sheet.addCell(status2);

		}

		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}
}
