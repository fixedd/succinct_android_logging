/*
 *    Copyright 2010 Jeremy Logan
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.fixedd.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * This class wraps the Android logger with a bunch of helper methods that
 * respect a minimum log level as set out in the manifest. The intent being that
 * if you use this class you won't have to manually disable all of your logging
 * calls before publishing, you'll only need to change the minimum level in
 * AndroidManifest.xml.
 * 
 * The second benefit of using this library is that it will give you automatic 
 * tag creation. It does this by using the name of the class of the passed-in 
 * object. So, for example, if you pass in a copy of MainActivity then the tag 
 * will be "MainActivity".
 * 
 * 
 * Usage: In your manifest (inside the application tag) add the following:
 * <pre>
 * {@code
 * <meta-data android:name="max_log_level" android:value="D" /> 
 * }
 * </pre>
 * This will set the max level to debug. The valid values are: "V" for VERBOSE,
 * "D" for DEBUG, "I" for INFO, "W" for WARN, "E" for ERROR, and "NONE" to log
 * nothing. 
 * 
 */
public final class Log {
	public static final String	LEVEL_VERBOSE	= "V";
	public static final String	LEVEL_DEBUG		= "D";
	public static final String	LEVEL_INFO		= "I";
	public static final String	LEVEL_WARN		= "W";
	public static final String	LEVEL_ERROR		= "E";
	public static final String	LEVEL_NONE		= "NONE";

	/**
	 * Write a "verbose" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void v(Context context, Object obj, String msg) {
		if (isAllowed(context, Log.LEVEL_VERBOSE)) {
			android.util.Log.v(getTag(obj), msg);
		}
	}

	/**
	 * Write a "verbose" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void v(Context context, Object obj, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_VERBOSE)) {
			android.util.Log.v(getTag(obj), msg, tr);
		}
	}

	/**
	 * Write a "verbose" message to the log. 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg  Message to write to the log.
	 */
	public static void v(Context context, String msg) {
		if (isAllowed(context, Log.LEVEL_VERBOSE)) {
			android.util.Log.v(getTag(context), msg);
		}
	}

	/**
	 * Write a "verbose" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void v(Context context, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_VERBOSE)) {
			android.util.Log.v(getTag(context), msg, tr);
		}
	}

	/**
	 * Write a "debug" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void d(Context context, Object obj, String msg) {
		if (isAllowed(context, Log.LEVEL_DEBUG)) {
			android.util.Log.d(getTag(obj), msg);
		}
	}

	/**
	 * Write a "debug" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void d(Context context, Object obj, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_DEBUG)) {
			android.util.Log.d(getTag(obj), msg, tr);
		}
	}

	/**
	 * Write a "debug" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void d(Context context, String msg) {
		if (isAllowed(context, Log.LEVEL_DEBUG)) {
			android.util.Log.d(getTag(context), msg);
		}
	}

	/**
	 * Write a "debug" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void d(Context context, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_DEBUG)) {
			android.util.Log.d(getTag(context), msg, tr);
		}
	}

	/**
	 * Write a "info" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void i(Context context, Object obj, String msg) {
		if (isAllowed(context, Log.LEVEL_INFO)) {
			android.util.Log.i(getTag(obj), msg);
		}
	}

	/**
	 * Write a "info" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void i(Context context, Object obj, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_INFO)) {
			android.util.Log.i(getTag(obj), msg, tr);
		}
	}

	/**
	 * Write a "info" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void i(Context context, String msg) {
		if (isAllowed(context, Log.LEVEL_INFO)) {
			android.util.Log.i(getTag(context), msg);
		}
	}

	/**
	 * Write a "info" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void i(Context context, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_INFO)) {
			android.util.Log.i(getTag(context), msg, tr);
		}
	}

	/**
	 * Write a "warn" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void w(Context context, Object obj, String msg) {
		if (isAllowed(context, Log.LEVEL_WARN)) {
			android.util.Log.w(getTag(obj), msg);
		}
	}

	/**
	 * Write a "warn" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void w(Context context, Object obj, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_WARN)) {
			android.util.Log.w(getTag(obj), msg, tr);
		}
	}

	/**
	 * Write a "warn" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void w(Context context, String msg) {
		if (isAllowed(context, Log.LEVEL_WARN)) {
			android.util.Log.w(getTag(context), msg);
		}
	}

	/**
	 * Write a "warn" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void w(Context context, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_WARN)) {
			android.util.Log.w(getTag(context), msg, tr);
		}
	}

	/**
	 * Write a "error" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void e(Context context, Object obj, String msg) {
		if (isAllowed(context, Log.LEVEL_ERROR)) {
			android.util.Log.e(getTag(obj), msg);
		}
	}

	/**
	 * Write a "error" message to the log. 
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param obj The object whose name should be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void e(Context context, Object obj, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_ERROR)) {
			android.util.Log.e(getTag(obj), msg, tr);
		}
	}

	/**
	 * Write a "error" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 */
	public static void e(Context context, String msg) {
		if (isAllowed(context, Log.LEVEL_ERROR)) {
			android.util.Log.e(getTag(context), msg);
		}
	}

	/**
	 * Write a "error" message to the log. 
	 * 
	 * @param context Use the "closest" context object possible (e.g. if you're 
	 *                in an activity or service use that and not the 
	 *                application activity) as this will be used as the tag.
	 * @param msg Message to write to the log.
	 * @param tr A throwable whose stack trace will also be written.
	 */
	public static void e(Context context, String msg, Throwable tr) {
		if (isAllowed(context, Log.LEVEL_ERROR)) {
			android.util.Log.e(getTag(context), msg, tr);
		}
	}

	/**
	 * Generates a tag name based on the passed-in object.
	 * @param obj An object to use to generate the tag. 
	 * @return Tag to use with log.
	 */
	private static String getTag(Object obj) {
		String toReturn = "";

		if (obj != null) {
			toReturn = obj.getClass().getSimpleName();
		}

		if (toReturn.length() == 0) {
			toReturn = "AnonymousClass";
		}

		return toReturn;
	}

	/**
	 * Whether the current maximum log level permits writing this log entry.
	 * 
	 * @param context Any context will do (application, service, activity, etc).
	 * @param logLevel One of the LEVEL_* constants.
	 * @return
	 */
	private static boolean isAllowed(Context context, String logLevel) {
		try {
			int maxLogLevel = stringLogLevelToNumeric(context.getPackageManager().getApplicationInfo(
				context.getPackageName(),
				PackageManager.GET_META_DATA).metaData.getString("max_log_level"));
			int currentLogLevel = stringLogLevelToNumeric(logLevel);

			if (currentLogLevel <= maxLogLevel) {
				return true;
			}
		} catch (NameNotFoundException e) {
			android.util.Log.e("Log", "Could not find log level in manifest.");
		}
		return false;
	}

	/**
	 * Converts a string representation of a log level (such as "D") to it's 
	 * numeric representation (such as 7).
	 * 
	 * @param logLevel
	 * @return
	 */
	private static int stringLogLevelToNumeric(String logLevel) {
		if (logLevel == LEVEL_NONE) {
			return -1;
		} else if (logLevel == LEVEL_ERROR) {
			return 3;
		} else if (logLevel == LEVEL_WARN) {
			return 4;
		} else if (logLevel == LEVEL_INFO) {
			return 6;
		} else if (logLevel == LEVEL_DEBUG) {
			return 7;
		} else if (logLevel == LEVEL_VERBOSE) {
			return 100;
		}
		throw new IllegalArgumentException("Invalid log level.");
	}

}
