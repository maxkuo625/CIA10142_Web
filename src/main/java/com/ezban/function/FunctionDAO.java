package com.ezban.function;

import java.util.List;

public interface FunctionDAO {
	
	int add(Function func);
	int update(Function func);
	int delete(Integer func_no);
	Function findByPK(Integer func_no);
	List<Function> getAll();

}
