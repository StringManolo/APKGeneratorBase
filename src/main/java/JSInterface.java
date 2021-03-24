package com.mimarca.MiPrimeraApp;

import android.content.Context;
import android.os.Vibrator;
import android.webkit.JavascriptInterface;

public class JSInterface {
  Context mContext;
  JSInterface(Context c) {
    mContext = c;
  }

  @JavascriptInterface
  public void Vibrate(long milliseconds) {
    Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
    v.vibrate(milliseconds);
  }
}
