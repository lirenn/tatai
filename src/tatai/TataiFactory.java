package tatai;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;


/**
** Factory class for utility functions.
** @author dli294
**/
public class TataiFactory {
	
	/**
	 * Finds all values in a map where the value is a certain value.
	 * @param map The map to search.
	 * @param value The value to find.
	 * @return A set of all the keys with this value.
	 * @author dli294
	 */
	public static Set<String> getKeysByValue(Map<String, Boolean> map, Boolean value) {
	    Set<String> keys = new HashSet<String>();
	    for (Entry<String, Boolean> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	
	/**
	 * Gets a random string from a set of strings.
	 * @param from The set to search in.
	 * @return Returns a random string.
	 * @author dli294
	 */
	public static String getRandomString(Set<String> from) {
		Random r = new Random();
		int i = r.nextInt(from.size());
		return (String) from.toArray()[i];
	}
     
}
