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
//Runs AS �� ������
@Controller
public class HomeController {
	private ArrayList<Article> articles = new ArrayList<Article>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int noTotalArticles = 0;
	private int noPapges;
	private String sError;
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
	
	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public String contents(Locale locale, Model model) {
		return "contents";

	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String artList(Locale locale, Model model, HttpServletRequest request) {	//HttpServletRequest param �߰�
		int ndxPage = 0 ;
		if (request.getParameter("first") != null) {
			initListPage() ;
		}
		if (request.getParameter("page") != null) {
			ndxPage = Integer.parseInt(request.getParameter("page"));
		}
		showPageX(ndxPage) ;
		model.addAttribute("strError", sError);
		model.addAttribute("noTotalArticles", noTotalArticles);	//${noTotalArticles}�� ���� �ش�.
		model.addAttribute("noPages", noPapges);
		//model.addAttribute("articlesList", articles); Model�� �Ѱ��������� Request�� �Ѱ��ָ� ���ڸ� jsp ���� �ȿ��� ���� �� �ִ�.
		request.setAttribute("articleList", articles) ;
		return "artList";	//������ jsp ���� �̸�
	}
	public void showPageX(int index){
		Connection con = null ;
		articles = new ArrayList<Article>() ;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			con = DriverManager.getConnection(url); 
			
			Statement st = con.createStatement() ;
	ResultSet rs = st.executeQuery(
			"select subject,name,created,hit,id from bbs_studypds order by created DESC") ;
	
			for(int i=0; i<index*10; i++) rs.next() ;
			int no = 0 ;
			while (rs.next()  &&  no<10) {
				Article art = new Article() ;
				art.setArticleNumber(noTotalArticles-index*10-no);
				art.setArticleTitle(rs.getString("subject"));
				art.setArticleAuthor(rs.getString("name"));
				art.setKey(rs.getInt("id"));
				
				String sDate = "" ;
				sDate += rs.getObject("created");
				int ndx = sDate.indexOf("00:");				
				art.setArticleDate(sDate.substring(0, ndx));
				
				art.setHitCount(rs.getInt("hit"));
				articles.add(art) ;
				no++ ;
			}
			st.close();
			con.close();
			System.out.println("well done!!");
		} 		catch (SQLException e) {
			System.out.println("Error on sql");
		}		catch (Exception e) {
			System.out.println("Error on DB-open ");
		}


	}
	public void initListPage(){			//�ʱ�ȭ �ϴ� ���� -> ���� �� ������ noTotalArticles �� noPage�� �� �ȹٲ��.
		Connection con = null;
		int count = 0;
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
			String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select subject, name, created, hit, id from bbs_studypds");
			while(rs.next()){			//�Խù� ���� �ľ�
				if(count < 10){
					String sDate = "";
					sDate += rs.getObject("created");
					int ndx = sDate.indexOf("00:");
					Article article = new Article();
					article.setKey(rs.getInt("id"));
					article.setArticleTitle(rs.getString("subject"));
					article.setArticleAuthor(rs.getString("name"));
					article.setArticleDate(sDate.substring(0, ndx));
					article.setHitCount(rs.getInt("hit"));
					articles.add(article); 
				}
				count++;
			}
			st.close();
			con.close();
			rs.close();

			noTotalArticles = count;
			noPapges = (count + 9)/10;
		}
		catch(SQLException e){
			sError = "Error on sqlDB";
		}
		catch(Exception e){
			sError = "Error on DB";
		}
	}
}
