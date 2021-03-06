package net.everythingandroid.smspopup;

import net.everythingandroid.smspopup.preferences.EmailDialogPreference;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.PreferenceActivity;

public class SMSPopupConfigActivity extends PreferenceActivity {
	private String version;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);

		//Try and find app version number
		version = "";
		PackageManager pm = this.getPackageManager();
		try {
			//Get version number, not sure if there is a better way to do this
			version = " v" +
			pm.getPackageInfo(
				SMSPopupConfigActivity.class.getPackage().getName(), 0).versionName;
		} catch (NameNotFoundException e) {
			//No need to do anything here if it fails
			//e.printStackTrace();
		}
		
		DialogPreference aboutPref =
			(DialogPreference) findPreference(getString(R.string.pref_about_key));
		aboutPref.setDialogTitle(getString(R.string.app_name) + version);
		aboutPref.setDialogLayoutResource(R.layout.about);
		
		EmailDialogPreference emailPref = (EmailDialogPreference) findPreference(getString(R.string.pref_sendemail_key));
		emailPref.setVersion(version);

		// Preference inboxPref = (Preference)
		// findPreference(getString(R.string.pref_inbox_app_key));
		// Intent inboxChooseIntent = new Intent();
		// inboxChooseIntent.setAction(Intent.ACTION_PICK_ACTIVITY);
		//		
		// Intent filterIntent = new Intent(Intent.ACTION_MAIN);
		// filterIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		
	// inboxChooseIntent.putExtra(Intent.EXTRA_INTENT, filterIntent);
		// inboxChooseIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		// <action android:name="android.intent.action.MAIN" />
		// <category android:name="android.intent.category.LAUNCHER" />

		// inboxPref.setIntent(inboxChooseIntent);

	}	
}