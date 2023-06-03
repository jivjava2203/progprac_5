package Test;

/**
 *
 * @author admin
 */
public class Sanitize {
    
    
        private static String getProperStringCasing(String str) {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
        public static String sanitize(String str) {
            int count = 0;
            str = str.trim();
            String [] arr = str.split(" ");
            String st = "";
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i].trim();
                        if (arr[i].isEmpty()) {
                            continue;
                        }
                        count++;
                        arr[i] = getProperStringCasing(arr[i]);
                            if (count == 1 ) {
                                st += arr[i];
                                    continue;
                            }
                                st += (" " + arr[i]);     
                            }
                return st;
                }
        
    
}
