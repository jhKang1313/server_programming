package server.spring.exam;

public class Article {
	private int articleID;
	private String articleTitle;
	private String articleAuthor;
	private String articleDate;
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
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public String getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	public int getArticleHit() {
		return articleHit;
	}
	public void setArticleHit(int articleHit) {
		this.articleHit = articleHit;
	}

}
