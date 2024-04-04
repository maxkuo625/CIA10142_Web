package com.ezban.member;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestMemberDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MemberDAO dao = new MemberDAOJDBCImpl();

		// 新增
		Member member1 = new Member();
		member1.setMember_no(2);
		member1.setMemeber_mail("member2@gmail.com");
		member1.setMember_pwd("1234567890");
		member1.setMember_name("jack");
		member1.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-08-07"));
		member1.setGender(1);
		member1.setMember_phone("0988222333");
		member1.setAddress("qqaaaqaqaaqaa");
		member1.setCommon_recipient("k");
		member1.setCommon_recipient_phone("0911122345");
		member1.setCommon_recipient_address("akdjskdjskdjsk");
		member1.setMember_status(1);
		member1.setMember_points(10);
		dao.add(member1);

		// 修改
		Member member2 = new Member();
		member2.setMemeber_mail("member2@gmail.com");
		member2.setMember_pwd("password2");
		member2.setMember_name("sam");
		member2.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-08-11"));
		member2.setGender(0);
		member2.setMember_phone("0988333444");
		member2.setAddress("qqaaaqaqaaqaala");
		member2.setCommon_recipient("k");
		member2.setCommon_recipient_phone("0911122345");
		member2.setCommon_recipient_address("akdjskdjskdjsk");
		member2.setMember_status(1);
		member2.setMember_points(20);
		member2.setMember_no(2);
		dao.update(member2);


		//查詢單筆
		Member member3 = dao.findByPK(1);
		System.out.print(member3.getMember_no() + ",");
		System.out.print(member3.getMemeber_mail() + ",");
		System.out.print(member3.getMember_pwd() + ",");
		System.out.print(member3.getMember_name() + ",");
		System.out.print(member3.getBirthday() + ",");
		System.out.print(member3.getGender() + ",");
		System.out.println(member3.getMember_phone());
		System.out.print(member3.getAddress() + ",");
		System.out.print(member3.getCommon_recipient() + ",");
		System.out.print(member3.getCommon_recipient_phone() + ",");
		System.out.print(member3.getCommon_recipient_address() + ",");
		System.out.print(member3.getMember_status() + ",");
		System.out.print(member3.getMember_points() + ",");
		System.out.println("---------------------");

		//查詢多筆
		List<Member> list = dao.getAll();
		for (Member mem : list) {
			System.out.print(mem.getMember_no() + ",");
			System.out.print(mem.getMemeber_mail() + ",");
			System.out.print(mem.getMember_pwd() + ",");
			System.out.print(mem.getMember_name() + ",");
			System.out.print(mem.getBirthday() + ",");
			System.out.print(mem.getGender() + ",");
			System.out.print(mem.getMember_phone());
			System.out.print(mem.getAddress() + ",");
			System.out.print(mem.getCommon_recipient() + ",");
			System.out.print(mem.getCommon_recipient_phone() + ",");
			System.out.print(mem.getCommon_recipient_address() + ",");
			System.out.print(mem.getMember_status() + ",");
			System.out.print(mem.getMember_points() + ",");
			System.out.println();
		}

	}
}
