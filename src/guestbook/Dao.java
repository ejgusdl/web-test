package guestbook;

import java.util.ArrayList;

public interface Dao {
	void insert(Article a); //글번호, 작성일 자동
	Article select(int num);
	ArrayList<Article> selectAll();
	void update(Article a);
	void delete(int num);
	
}
