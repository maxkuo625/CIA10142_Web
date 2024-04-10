package com.ezban.eventComment;

import java.util.List;

public interface eventCommentDAO {
	
	int add(Event_comment ecomment);
	int update(Event_comment ecomment);
	int delete(Integer event_comment_no);
	Event_comment findByPK(Integer event_comment_no);
	List<Event_comment> getAll();

}
