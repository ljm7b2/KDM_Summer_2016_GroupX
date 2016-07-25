import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;

import org.json.JSONObject;

public class QueryVirtuoso {
	
	public static JSONObject QueryData(String userQuery)
	{
		JSONObject queryResults = new JSONObject();		
		String service = "http://localhost:8890/sparql";		
		String queryAndPrefix = "PREFIX d: <https://www.mnpkdm.com/OWL/disease#> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + userQuery;		
		Query query = QueryFactory.create(queryAndPrefix);
		
		QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);		
	    try {
	        ResultSet results = qe.execSelect() ;
	        int counter = -1;
	        for ( ; results.hasNext() ; ) {
	            QuerySolution soln = results.nextSolution() ;
	            RDFNode i = soln.get("i") ;
	            System.out.println(i.toString());
	            counter++;
	            if(i.toString().contains("https://www.mnpkdm"))
	            {
	            	queryResults.put("Result_" + Integer.toString(counter), i.toString().substring(i.toString().indexOf("#") + 1));
	            }else{
	            	queryResults.put("Result_" + Integer.toString(counter), i.toString().substring(0, i.toString().indexOf("^")));
	            }
	        }
	        queryResults.put("total", Integer.toString(counter));
	     } catch (Exception e) {
	         System.out.println("Query error:"+e);
	         return queryResults.put("query", "failure");
	     } finally {
	         qe.close();
	     }	    
	    queryResults.put("query", "success");
		return queryResults;
	}

}
