package server.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private String pError;
	private ArrayList<Article> articles = new ArrayList<Article>();
	private int articleCount;
	private int pageCount;
	private int currPage;
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
	public String articleList(Locale locale, Model model, HttpServletRequest request) {
		articleInit();
		int page = 0;
		if(request.getParameter("page") == null)
			page = 1;
		else
			page = Integer.parseInt(request.getParameter("page"));
		currPage = page;
		model.addAttribute("pError", pError);
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("articles", articles);
		return "articleList";
	}
	public void articleInit(){
		pError = "Succeed";
		articleCount = 0;
		pageCount = 0;
		try{
			/*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
			ConnectionMaker connection = factory.getBean("connectionMaker", ConnectionMaker.class);
			Connection con = connection.getConnection();*/
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			Connection con = DriverManager.getConnection(url);
																															
			PreparedStatement ps = con.prepareStatement("select id, subject, name, created, contents, hit from bbs_studypds order by created DESC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article newArticle = new Article();
				newArticle.setArticleID(rs.getInt("id"));
				newArticle.setArticleAuthor(rs.getString("name"));
				newArticle.setArticleContent(rs.getString("contents"));
				newArticle.setArticleHit(rs.getInt("hit"));
				newArticle.setArticleTitle(rs.getString("subject"));
				newArticle.setArticleDate(rs.getString("created").substring(0, 11));
				
				articles.add(newArticle);
				articleCount++;
			}
			ps.close();
			rs.close();
			con.close();
		}
		catch(Exception e){
			pError = "Failed";
		}
		pageCount = (articleCount + 9) / 10;
	}
	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public String contents(Locale locale, Model model, HttpServletRequest request) {
		
		request.setAttribute("articles", articles);
		return "contents";
	}
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Locale locale, Model model, HttpServletRequest request) {
		
		request.setAttribute("articles", articles);
		return "notice";
	}
}
