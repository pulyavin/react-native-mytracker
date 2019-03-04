package com.mytracker.reactnative;

import android.app.Application;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.my.tracker.MyTracker;

class RNMyTrackerModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext reactContext;
    private Application application;

    public RNMyTrackerModule(ReactApplicationContext reactContext) {
        super(reactContext);

        this.reactContext = reactContext;
        this.application = (Application) reactContext.getApplicationContext();
    }

    @Override
    public String getName() {
        return "RNMyTracker";
    }

    @ReactMethod
    public void initSdk(String sdkKey) {
        MyTracker.createTracker(sdkKey, application.getApplicationContext());
        MyTracker.initTracker();
    }

    @ReactMethod
    public void trackEvent(String name) {
        MyTracker.trackEvent(name);
        MyTracker.flush();
    }
}