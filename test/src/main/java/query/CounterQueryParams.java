package query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CounterQueryParams
{

	@Test
    public void parseAsInsert() throws Exception
    {

        String name = "params.txt";
        String file = readFileAsString(name);
        // file = "(a\n\r)";
        // file = buf.toString();
        Pattern p = Pattern.compile("\\([^\\)^\\(]+?\\)");
        Matcher m = p.matcher(file);

        List<String[]> groups = new LinkedList<String[]>();

        while (m.find())
        {
            String found = m.group();
            String[] columns = split(found);
            groups.add(columns);
            System.out.println(columns.length + " : " + found);
        }

        if (groups.size() == 2)
        {

            String[] l1 = groups.get(0);
            String[] l2 = groups.get(1);
            for (int i = 0; i < l1.length; i++)
            {
                System.out.println(l1[i] + " = " + l2[i]);
            }

        }

    }

    private static String readFileAsString(String name) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(CounterQueryParams.class.getResourceAsStream(name)));
        StringBuilder sb = new StringBuilder();
        int read = 0;
        char[] chars = new char[1024];
        while ((read = br.read(chars)) != -1)
        {
            sb.append(chars, 0, read);
        }
        return sb.toString();
    }

    private static String[] split(String str)
    {
        List<String> l = new LinkedList<String>();
        char[] cs = str.toCharArray();
        int lastIndex = 0;
        boolean insideQuotes = false;
        for (int i = 0; i < cs.length; i++)
        {
            char c = cs[i];
            if (c == '\'')
            {
                insideQuotes = !insideQuotes;
            }
            if (c == ',' && !insideQuotes)
            {
                l.add(str.substring(lastIndex, i));
                lastIndex = i + 1;
            }
        }
        return l.toArray(new String[l.size()]);
    }
}
