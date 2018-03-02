package firefly;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put(null, "abc");

		System.out.println(map.get(null));
		
	}
	
    
}
