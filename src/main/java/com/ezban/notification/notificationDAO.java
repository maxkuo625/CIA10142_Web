package com.ezban.notification;

import java.util.List;

public interface notificationDAO {
	
	int add(Notification notify);
	int update(Notification notify);
	int delete(Integer notification_no);
	Notification findByPK(Integer notification_no);
	List<Notification> getAll();

}
