package customviews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedOutput;

public class RssCustomView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_1.0");
		feed.setAuthor("Author");
		feed.setTitle("Title");
		feed.setDescription("description");
		feed.setLink("link");

		List entries = new ArrayList();
		
		for (int i = 0; i< 1000; i++) {

			SyndEntry entry = new SyndEntryImpl();
			entry.setTitle("Title " + i);
			entry.setLink("http://www.roadrantz.com");
			entry.setPublishedDate(new Date());

			SyndContent content = new SyndContentImpl();
			content.setType("text/html");
			content.setValue("" + i);
			entry.setDescription(content);

			entries.add(entry);
		}

		feed.setEntries(entries);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed, response.getWriter());

	}

}
