

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.sql.*;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/";
   
	//  Database credentials
	private static final String USER = "uroot";
	private static final String PASS = "";
   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
      
    }
    public void init(ServletConfig config) throws ServletException {
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String JsonStr1 = request.getParameter("json1");
		
		JsonElement ele = new JsonParser().parse(JsonStr1);
		JsonObject jsobj = ele.getAsJsonObject();
		//System.out.println(jsobj.get("name").toString());
		//System.out.println(jsobj.get("id").toString());
		
		String name = jsobj.get("name").toString().replaceAll("\"","");
		String id = jsobj.get("id").toString().replaceAll("\"","");
		String first_name = jsobj.get("first_name").toString().replaceAll("\"","");
		String last_name = jsobj.get("last_name").toString().replaceAll("\"","");
		String link = jsobj.get("link").toString().replaceAll("\"","");
		String username = jsobj.get("username").toString().replaceAll("\"","");
		String birthday = jsobj.get("birthday").toString().replaceAll("\"","");
		String gender = jsobj.get("gender").toString().replaceAll("\"","");
		String email = jsobj.get("email").toString().replaceAll("\"","");
		
		String temp = "'"+name+"',"+"'"+id+"',"+"'"+first_name+"',"+"'"+last_name+"',"+"'"+link+"',"+"'"+username+"',"
				+"'"+birthday+"',"+"'"+gender+"',"+"'"+email+"'";
		
		//String temp = name+","+id+","+first_name+","+last_name+","+link+","+username+","+birthday
			//	+","+gender+","+email;
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			
			statement = connection.createStatement();
			
			String sql = "INSERT INTO test.fb "
					+ "(`name`, `id`, `first_name`, `last_name`, `link`, `username`, `birthday`, `gender`, `email`) "
					+ "VALUES ("+temp+")";
			//System.out.println(sql);
			statement.execute(sql);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("debug");
			PrintWriter pw = response.getWriter();
			Person p = new Person(name, id, first_name, last_name, link, username, birthday, gender, email);
			System.out.println(p.getData());
			pw.println("Successfully written the following data to DB : \n" +p.getData()  );
			pw.close();

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
