

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class QueryOntology
 */
@WebServlet("/QueryOntology")
public class QueryOntology extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject queryResults;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOntology() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		queryResults = QueryVirtuoso.QueryData(request.getParameter("query"));
//		if(queryResults.get("query").equals("success"))
//		{
//			int top = Integer.valueOf(queryResults.get("total").toString());
//			for(int i =0; i < top; i++ )
//			{
//				String result = (String) queryResults.get("Result_" + Integer.toString(i));
//				
//				String resultTrim = result.substring(0, result.indexOf("^"));
//				
//				System.out.println(resultTrim);
//			}
//		}
		
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		response.setContentType("application/json");     
		PrintWriter out = response.getWriter();  
		out.print(queryResults);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//JSONObject queryResults = QueryOntology.QueryData("SELECT ?i WHERE { d:LungCancer d:hasSymptoms ?i}");
//if(queryResults.get("query").equals("success"))
//{
//	int top = Integer.valueOf(queryResults.get("total").toString());
//	for(int i =0; i < top; i++ )
//	{
//		System.out.println(queryResults.get("Result_" + Integer.toString(i)));
//	}
//}
