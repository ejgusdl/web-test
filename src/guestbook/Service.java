package guestbook;

import java.util.ArrayList;

public interface Service {
	void addArticle(Article a);
	Article getArticle(int num);
	ArrayList<Article> getAll();
	void editArticle(Article a);
	void delArticle(int num);
		
}
