package util;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class ResponseUtil {

    private Object getJsonField(Response testBundle, String jsonPath) {
        Object value = testBundle.readEntity(Map.class);
        for (String path : jsonPath.split("\\.")) {

            boolean pathIsArray = false;
            Pattern arrayPattern = Pattern.compile("(.+)\\[\\d+\\]");
            Matcher matcher = arrayPattern.matcher(path);
            String var = path;
            int index = 0;
            if (matcher.find()){
                pathIsArray=true;
                var =  matcher.group(1);
                index = Integer.valueOf(matcher.group(2));
            }

            if (value == null || !(value instanceof Map)) {
                return null;
            } else if (pathIsArray) {
                value = ((List)((Map<String, Object>) value).get(var)).get(index);
            }else{
                value = ((Map<String, Object>) value).get(path);
            }
        }
        return value;
    }

}
