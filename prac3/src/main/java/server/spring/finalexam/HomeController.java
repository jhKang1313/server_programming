package server.spring.finalexam;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	String Error;
	ArrayList<Article> articles;
	int articleCount;
	int pageCount;
	int currCount;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model, HttpServletRequest request) {
		initArticle();
		
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("Error", Error);
		return "main";
	}
	public void initArticle(){
		Error = "Succeed";
		articles = new ArrayList<Article>();
		articleCount = 0;
		pageCount = 0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			Connection con = DriverManager.getConnection(url);
			
			PreparedStatement ps = con.prepareStatement("select id, subject, name, created, hit from bbs_studypds order by created DESC" );
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article newArticle = new Article();
				newArticle.setArticleAuthor(rs.getString("name"));
				newArticle.setArticleHit(rs.getInt("hit"));
				newArticle.setArticleDate(rs.getString("created").substring(0, 11));
				newArticle.setArticleID(rs.getInt("id"));
				newArticle.setArticleTitle(rs.getString("subject"));
				
				articles.add(newArticle);
				articleCount++;
			}
			//pageCount = (articleCount + 9) / 10;
			con.close();
			ps.close();
			rs.close();
		}
		catch(Exception e){
			Error = "Faild"; 
		}
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpServletRequest request) {
		String aCount = request.getParameter("article_count");
		if(aCount.equals("five"))
			pageCount = (articleCount + 4) / 5;
		else if(aCount.equals("ten"))
			pageCount = (articleCount + 9) / 10;
		else if(aCount.equals("fif"))
			pageCount = (articleCount + 14) / 15;
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("articles", articles);
		return "list";
	}
}
