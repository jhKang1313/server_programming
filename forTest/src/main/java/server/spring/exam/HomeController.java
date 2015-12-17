package server.spring.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	ArrayList<Article> articles = new ArrayList<Article>();
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
	public String articleList(Locale locale, Model model){
		int articleCount = 0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			Connection con = DriverManager.getConnection(url);
			
			PreparedStatement ps = con.prepareStatement("select id, subject, name, created, hit from bbs_studypds" );
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article temp = new Article();
				temp.articleID = rs.getInt("id");
				temp.articleTitle = rs.getString("subject");
				temp.articleAuthor = rs.getString("name");
				temp.articleDate = rs.getString("created");
				temp.articleHit = rs.getInt("hit");
				articles.add(temp);
				articleCount++;
			}
			
			
			model.addAttribute("count", articleCount);
			
			con.close();
			ps.close();
			rs.close();
		}
		catch(Exception e){
			System.out.println("Error");
		}
		System.out.println("good");
		return "articleList";
	}
	
}
