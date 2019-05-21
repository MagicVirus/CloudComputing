package objects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@Path("/getStock")
public class StockService {
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/{isbn}")
    public Object getBookStockByISBN(@PathParam("isbn") Long isbn) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		  if (isbn != null) {
			  Filter propertyFilter = new FilterPredicate("ISBN", FilterOperator.EQUAL, isbn);
			  Query q = new Query("Book").setFilter(propertyFilter);
			  System.out.println(q);
			  Entity result;
			  try {
		          result = datastore.prepare(q).asSingleEntity();
				  return new Book(
						  Long.parseLong((String) result.getProperty("ISBN")),
						  Integer.parseInt((String) result.getProperty("Stock")), 
						  (String) result.getProperty("Name"));
			    } catch (NullPointerException ex) {
		            return new Book((Long)null, null, null);
			   
			    }
		  }else {
	            return new Book((Long)null, null, null);
		}
    }
}
