package pt.link.sc.transaction.api.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PropertyUtils {

	private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);
	
	private PropertyUtils() {}

	/**
	 * Load the properties defined in the file with the given name
	 * onto the given {@link Properties} instance.
	 * <p>
	 * The file lookup order for the given filename is as follows:
	 * <ol>
	 * <li>The configuration folder of the JBoss AS instance hosting the app
	 * (system property 'jboss.server.config.dir')</li>
	 * <li>The classpath of the app</li>
	 * </ol>
	 * 
	 * @param props
	 * @param fileName
	 */
	public static void loadProperties(Properties props, String fileName) {
		try (InputStream is = getFileStream(fileName)) {
			props.load(is);
		} catch (IOException e) {
			log.error("Error loading configurations from '" + fileName + "'", e);
		}
	}
	
	public static InputStream getFileStream(String fileName) {
		try {
			final String configDirPath = getConfigDirPath();
			
			log.debug("Looking for '" + fileName + "' in '" + configDirPath + "'");
			
			return new FileInputStream(configDirPath + "/" + fileName);
		} catch (FileNotFoundException e) {
			log.debug("Looking for '" + fileName + "' in app classpath");
			
			return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		}
	}
	
	private static String getConfigDirPath() {
		String path = System.getProperty("jboss.server.config.dir");
		if (path == null) path = "";
		return path;
	}
	
}
