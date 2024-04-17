package com.ezban.eventComment;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestEventCommentDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		eventCommentDAO dao = new eventCommentDAOJDBCImpl();
		LocalDateTime now = LocalDateTime.now();
		// Timestamp timestamp = Timestamp.valueOf(now);

		// 新增
		Event_comment ecomment1 = new Event_comment();
		ecomment1.setEventCommentNo(2);
		ecomment1.setEventNo(1);
		ecomment1.setMemberNo(1);
		ecomment1.setEventCommentContent("this is a postive comment");
		ecomment1.setEventCommentRate(4);
		ecomment1.setEventCommentTime(now);
		ecomment1.setEventCommentStatus((byte) 1);
		
		dao.add(ecomment1);

		// 修改
		Event_comment ecomment2 = new Event_comment();
		ecomment2.setEventCommentNo(2);
		ecomment2.setEventNo(2);
		ecomment2.setMemberNo(1);
		ecomment2.setEventCommentContent("this is a postive comment again");
		ecomment2.setEventCommentRate(5);
		ecomment2.setEventCommentTime(now);
		ecomment2.setEventCommentStatus((byte) 0);
		dao.update(ecomment2);


		// 查詢單筆
		Event_comment ecomment3 = dao.findByPK(1);
		System.out.print(ecomment3.getEventCommentNo() + ",");
		System.out.print(ecomment3.getEventNo() + ",");
		System.out.print(ecomment3.getMemberNo() + ",");
		System.out.print(ecomment3.getEventCommentContent() + ",");
		System.out.print(ecomment3.getEventCommentRate() + ",");
		System.out.print(ecomment3.getEventCommentTime() + ",");
		System.out.println(ecomment3.getEventCommentStatus());
		System.out.println("---------------------");

		//查詢多筆
		List<Event_comment> list = dao.getAll();
		for (Event_comment ecomment : list) {
			System.out.print(ecomment3.getEventCommentNo() + ",");
			System.out.print(ecomment3.getEventNo() + ",");
			System.out.print(ecomment3.getMemberNo() + ",");
			System.out.print(ecomment3.getEventCommentContent() + ",");
			System.out.print(ecomment3.getEventCommentRate() + ",");
			System.out.print(ecomment3.getEventCommentTime() + ",");
			System.out.println(ecomment3.getEventCommentStatus());
			System.out.println("---------------------");
			System.out.println();
			}

	}

}
