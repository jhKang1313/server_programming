package server.spring.finalexam;


public class Article {
	private int articleID;
	private String articleTitle;
	private String articleDate;
	private String articleAuthor;
	private int articleHit;
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public int getArticleHit() {
		return articleHit;
	}
	public void setArticleHit(int articleHit) {
		this.articleHit = articleHit;
	}

}
