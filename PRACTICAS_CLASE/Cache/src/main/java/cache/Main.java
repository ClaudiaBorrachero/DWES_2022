package cache;

import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		Map<String,String> cache = Cache.getcache();
		cache.put(" ", " ");
	}

}
