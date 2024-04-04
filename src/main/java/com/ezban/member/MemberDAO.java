package com.ezban.member;

import java.util.List;

public interface MemberDAO {
	
	int add(Member mem);
	int update(Member mem);
	Member findByPK(Integer member_no);
	List<Member> getAll();

}
