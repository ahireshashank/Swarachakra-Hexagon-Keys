package iit.android.swarachakraMarathi;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

public class KeyLogger {
	private static long uploadFreq = 7 * 24 * 60; // every 6 days 7 * 24 * 60
	private static long uploadtimestamp = 0;
	private static final String stringUrl = "";
	private static String map;
	private static String language;
	public final String TAG = "logger";
	private HashMap<String,Integer> ht;
	public String extractedText;
	private SoftKeyboard mSoftKeyboard;
	String draft_msg="";
	
	public void setSoftKeyboard(SoftKeyboard softKeyboard) {
		mSoftKeyboard = softKeyboard;
		language = mSoftKeyboard.getResources().getString(R.string.language_name);
		map = "muppetymap" + language + ".dat";
	}

	public void writeToLocalStorage() {
		

	}

	@SuppressWarnings("unchecked")
	public void readMap(String filename) {

		
	}

	public void addToMap(String key) {


	}

	@SuppressWarnings("finally")
	public String uploadFile() {

		return "";
	}

	@SuppressWarnings("unused")
	public boolean hasExternalStoragePrivateFile(String fName) {
		// Get path for the file on external storage. If external
		// storage is not currently mounted this will fail.
		File file = new File(mSoftKeyboard.getExternalFilesDir(null), fName);
		if (file != null) {
			return file.exists();
		}
		return false;
	}

	public void writeMapToFile() {

	
	}

	// deleteFile
	public void deleteNamedFile(String filename) {
		// Log.d(TAG,"Delete "+filename);


	}

	// when connection available, upload to the server

	public void uploadToServer() {
		

	}

	// Given a URL, establishes an HttpUrlConnection and retrieves
	// the web page content as a InputStream, which it returns as
	// a string.

	// Uses AsyncTask to create a task away from the main UI thread. This task
	// takes a
	// URL string and uses it to create an HttpUrlConnection. Once the
	// connection
	// has been established, the AsyncTask downloads the contents of the webpage
	// as
	// an InputStream. Finally, the InputStream is converted into a string,
	// which is
	// displayed in the UI by the AsyncTask's onPostExecute method.
	public class SendStatsTask extends AsyncTask<String, Void, String> {
		// @Override
		protected String doInBackground(String... urls) {
			// return downloadUrl(urls[0]);
			// return sendLog();
			// String uploadText=readFromFile("swcLog.txt");

			// Log.d(TAG,"In thread..trying to connect..sending-"+uploadText);
			Log.d(TAG, "In thread..trying to connect..sending-");
			// return postData(urls[0],
			// "postwords="+URLEncoder.encode(uploadText));
			return uploadFile();
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			// textView.setText(result);
			// System.out.println(result);
			//Log.d(TAG, "Result returned");
			if (result.isEmpty()) {
				//Log.d(TAG, "Result string empty");
				return;
			}
			if (result.contains("ok:200")) {
				Log.d(TAG, "Delete log file");
				deleteNamedFile(map);
			}
		}
	}
}
