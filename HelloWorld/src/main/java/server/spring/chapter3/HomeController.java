package server.spring.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
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
//Runs AS 로 실행해
@Controller
public class HomeController {
	private ArrayList<Article> articles = new ArrayList<Article>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = "2015-11-27- Thur. 4:33:59";
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String artList(Locale locale, Model model, HttpServletRequest request) {	//HttpServletRequest param 추가
		int noTotalArticles = 0;
		Connection con = null;
		String sError = "Success";
		int count = 0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select subject, name, created, hit from bbs_studypds");
			while(rs.next()){			//게시물 개수 파악
				if(count < 10){
					Article article = new Article();
					article.setArticleTitle(rs.getString("subject"));
					article.setArticleAuthor(rs.getString("name"));
					article.setArticleDate(rs.getString("created"));
					article.setHitCount(rs.getInt("hit"));
					articles.add(article);
				}
				count++;
			}
	/*		Article article = new Article();
			article.setArticleNumber(1142);
			article.setArticleTitle("운영체제 5장");
			article.setArticleAuthor("정경원");
			article.setArticleDate("2006-10-18");
			article.setHitCount(35);
			articles.add(article);
			
			article = new Article();
			article.setArticleNumber(1141);
			article.setArticleTitle("운영체제 4장");
			article.setArticleAuthor("정경원");
			article.setArticleDate("2006-10-17");
			article.setHitCount(2);
			articles.add(article);
	*/		
			noTotalArticles = count;
			rs.close();
			st.close();
			con.close();
		}
		catch(SQLException e){
			sError = "Error on sqlDB";
		}
		catch(Exception e){
			sError = "Error on DB";
		}
		int noPapges = (noTotalArticles+9)/ 10;
		model.addAttribute("strError", sError);
		model.addAttribute("noTotalArticles", noTotalArticles);	//${noTotalArticles}에 값을 준다.
		model.addAttribute("noPages", noPapges);
		//model.addAttribute("articlesList", articles); Model로 넘겨주지말고 Request로 넘겨주면 인자를 jsp 파일 안에서 받을 수 있다.
		request.setAttribute("articleList", articles) ;
		return "artList";	//보여줄 jsp 파일 이름
	}
}
