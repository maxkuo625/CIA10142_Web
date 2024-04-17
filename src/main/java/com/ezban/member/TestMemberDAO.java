package com.ezban.member;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestMemberDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MemberDAO dao = new MemberDAOJDBCImpl();

		// 新增
		Member member1 = new Member();
		member1.setMemberNo(2);
		member1.setMemeberMail("member2@gmail.com");
		member1.setMemberPwd("1234567890");
		member1.setMemberName("jack");
		member1.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-08-07"));
		member1.setGender(1);
		member1.setMemberPhone("0988222333");
		member1.setAddress("qqaaaqaqaaqaa");
		member1.setCommonRecipient("k");
		member1.setCommonRecipientPhone("0911122345");
		member1.setCommonRecipientAddress("akdjskdjskdjsk");
		member1.setMemberStatus((byte) 1);
		member1.setMemberPoints(10);
		dao.add(member1);

		// 修改
		Member member2 = new Member();
		member2.setMemeberMail("member2@gmail.com");
		member2.setMemberPwd("password2");
		member2.setMemberName("sam");
		member2.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-08-11"));
		member2.setGender(0);
		member2.setMemberPhone("0988333444");
		member2.setAddress("qqaaaqaqaaqaala");
		member2.setCommonRecipient("k");
		member2.setCommonRecipientPhone("0911122345");
		member2.setCommonRecipientAddress("akdjskdjskdjsk");
		member2.setMemberStatus((byte) 1);
		member2.setMemberPoints(20);
		member2.setMemberNo(2);
		dao.update(member2);


		//查詢單筆
		Member member3 = dao.findByPK(1);
		System.out.print(member3.getMemberNo() + ",");
		System.out.print(member3.getMemeberMail() + ",");
		System.out.print(member3.getMemberPwd() + ",");
		System.out.print(member3.getMemberName() + ",");
		System.out.print(member3.getBirthday() + ",");
		System.out.print(member3.getGender() + ",");
		System.out.println(member3.getMemberPhone());
		System.out.print(member3.getAddress() + ",");
		System.out.print(member3.getCommonRecipient() + ",");
		System.out.print(member3.getCommonRecipientPhone() + ",");
		System.out.print(member3.getCommonRecipientAddress() + ",");
		System.out.print(member3.getMemberStatus() + ",");
		System.out.print(member3.getMemberPoints() + ",");
		System.out.println("---------------------");

		//查詢多筆
		List<Member> list = dao.getAll();
		for (Member mem : list) {
			System.out.print(mem.getMemberNo() + ",");
			System.out.print(mem.getMemeberMail() + ",");
			System.out.print(mem.getMemberPwd() + ",");
			System.out.print(mem.getMemberName() + ",");
			System.out.print(mem.getBirthday() + ",");
			System.out.print(mem.getGender() + ",");
			System.out.print(mem.getMemberPhone());
			System.out.print(mem.getAddress() + ",");
			System.out.print(mem.getCommonRecipient() + ",");
			System.out.print(mem.getCommonRecipientPhone() + ",");
			System.out.print(mem.getCommonRecipientAddress() + ",");
			System.out.print(mem.getMemberStatus() + ",");
			System.out.print(mem.getMemberPoints() + ",");
			System.out.println();
		}

	}
}
