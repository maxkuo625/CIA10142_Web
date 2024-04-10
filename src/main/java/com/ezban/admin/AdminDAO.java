package com.ezban.admin;

import java.util.List;

public interface AdminDAO {
	
	int add(Admin admin);
	int update(Admin admin);
	int delete(Integer admin_no);
	Admin findByPK(Integer admin_no);
	List<Admin> getAll();

}
