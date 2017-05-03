package learning.hibernate.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			/**
			 * new Configuration() - this is for mapping files <mapping resource=".hbm.xml" />
			 * new AnnotationConfiguration - this is for annotations <mapping class="" />
			 */
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			/**
			 * 1. new Configuration() searches for hibernate.properties in the
			 * classpath and loads all hibernate.* properties 2. .configure() -
			 * searches hibernate.cfg.xml in the classpath root
			 * 
			 */
		}
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	public static void getStatistics() {
		Statistics stats = getSessionFactory().getStatistics();
		stats.setStatisticsEnabled(true);

		stats.getSessionOpenCount();
		stats.logSummary();
		EntityStatistics itemStats = stats
				.getEntityStatistics("learning.hibernate.entities.Message");

		/*
		 * CollectionStatistics for a particular collection role,
		 * QueryStatistics for SQL and HQL queries, and Sec-
		 * ondLevelCacheStatistics for detailed runtime information about a
		 * particular region in the optional second-level data cache. A
		 * convenient method is logSum- mary(), which prints out a complete
		 * summary to the console with a single call.
		 * 
		 * If you want to enable the collection of statistics through the
		 * configuration, and not programmatically, set the
		 * hibernate.generate_statistics configuration prop- erty to true.
		 */

		System.out.println(itemStats.getFetchCount());

	}
}
