package corelib;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogLevel;

/**
 * Exposes methods to initialize logger which would write logs to standard I/O
 */
public class Log {

	static Logger logInstance = Logger.getLogger("file");
	public static String appendCharacter = "";

	public static void Message(String message, LogLevel logLevel) {
		if (!appendCharacter.equals("")) {
			message = appendCharacter + message;
		}
		switch (logLevel.toString()) {
		case "ERROR":
			logInstance.error(message);
			break;
		case "INFO":
			logInstance.info(message);
			break;
		case "DEBUG":
			logInstance.debug(message);
			break;
		}
	}
}
