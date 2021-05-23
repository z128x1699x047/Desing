import java.util.HashMap;
import java.util.Map;

public class HttpClientUtils {
	private static final int default_connection_out = 2*60*1000;
	private static final int default_sotimeout=3*60*1000;
	
	public static Map<String,Object> requestByGetReturnMap(String url,Map<String,String> headers){
		return requestByGetReturnMap(url,headers,default_connection_out,default_sotimeout);	
	}
	
	public static Map<String,Object> requestByGetReturnMap(String url,Map<String,String> headers,
			int connectionTimeOut,int soTimeOut){
			Map<String,Object> returnMap = new HashMap<>();
			return null;		
	}
}
