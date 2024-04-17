package com.ezban.host;

import java.util.List;

public interface HostDAO {
	
	int add(Host host);
	int update(Host host);
	Host findByPK(Integer hostNo);
	List<Host> getAll();

}
