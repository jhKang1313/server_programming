package server.spring.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@Controller
public class HomeController {
	ArrayList<Article> articles;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String error;
	int totalArticleCount;
	int totalPageCount;
	int currPage;
 	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String articleList(Locale locale, Model model, HttpServletRequest request){
		initArticle();
		if(request.getParameter("first")!= null){
			currPage = 0;
		}
		if(request.getParameter("page")!= null){
			currPage = Integer.parseInt(request.getParameter("page"));
			currPage--;
		}
		model.addAttribute("dbError", error);
		model.addAttribute("totalArticleCount", totalArticleCount);

		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("articles", articles); 
		return "articleList";  
	}
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(Locale locale, Model model){
		return "content";  
	}
	
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Locale locale, Model model){
		return "notice";  
	}
	
	public void initArticle(){
		error = "Succeed";
		articles = new ArrayList<Article>();
		totalArticleCount = 0;
		totalPageCount = 0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			Connection con = DriverManager.getConnection(url);
			
			PreparedStatement ps = con.prepareStatement("select id, subject, name, created, hit from bbs_studypds order by created DESC" );
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article temp = new Article();
				temp.setArticleID(rs.getInt("id"));
				temp.setArticleTitle(rs.getString("subject"));
				temp.setArticleAuthor(rs.getString("name"));
				 
				String articleDate = rs.getString("created");
				articleDate = articleDate.substring(0, 11);
				
				temp.setArticleDate(articleDate);
				temp.setArticleHit(rs.getInt("hit"));
				articles.add(temp);
				totalArticleCount++;
			}
			totalPageCount = (totalArticleCount + 9)/10;
			con.close();
			ps.close();
			rs.close();
		}
		catch(Exception e){
			error = "Failed";
		}
	}
}
