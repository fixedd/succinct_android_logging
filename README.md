Succinct Android Logging
========================

This class wraps the Android logger with a bunch of helper methods that respect a minimum log level as set out in the manifest. The intent being that if you use this class you won't have to manually disable all of your logging calls before publishing, you'll only need to change the minimum level in AndroidManifest.xml.

The second benefit of using this library is that it will give you automatic tag creation. It does this by using the name of the class of the passed-in object. So, for example, if you do something like this:
```java
public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		Log.v(this, "Hello from onCreate()");
		// ...
	}
}
```
then the tag used for the log would be "MainActivity".


Setup
-----

As mentioned, you'll need a new piece of meta data in yout manifest. Inside the `<application>` tags add the following `meta-data` tag:
```xml
<meta-data android:name="max_log_level" android:value="D" /> 
```
This will set the max level to debug. The valid values are: 
* "V" for VERBOSE logging
* "D" for DEBUG (and above) logging
* "I" for INFO (and above) logging
* "W" for WARN (and above) logging
* "E" for ERROR (and above) logging
* "NONE" to log nothing
