package com.ezban.productComment;

import java.util.List;

public interface productCommentDAO {
	
	int add(Product_comment pcomment);
	int update(Product_comment pcomment);
	int delete(Integer product_comment_no);
	Product_comment findByPK(Integer product_comment_no);
	List<Product_comment> getAll();

}
