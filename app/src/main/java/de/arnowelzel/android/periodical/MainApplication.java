package de.arnowelzel.android.periodical;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.zeugmasolutions.localehelper.LocaleHelperApplicationDelegate;

import java.util.Locale;

public class MainApplication extends Application {
    private LocaleHelperApplicationDelegate localeAppDelegate = new LocaleHelperApplicationDelegate();
    public static String systemLanguage;

    @Override
    public void onCreate() {
        super.onCreate();

        systemLanguage = Locale.getDefault().getLanguage();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(localeAppDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeAppDelegate.onConfigurationChanged(this);
        systemLanguage = Locale.getDefault().getLanguage();
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {

    }
}
