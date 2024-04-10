package com.ezban.pointsRecord;

import java.util.List;

public interface pointsRecordDAO {
	
	int add(Points_record poRecord);
	int update(Points_record poRecord);
	int delete(Integer points_record_no);
	Points_record findByPK(Integer points_record_no);
	List<Points_record> getAll();

}
