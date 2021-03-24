package com.mimarca.MiPrimeraApp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.annotation.TargetApi;

public class ActividadPrincipal extends Activity {
  private WebView MiWebView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    MiWebView  = new WebView(this);
    WebSettings webSettings = MiWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    String MiUserAgent = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; SM-N900T Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    MiWebView.getSettings().setUserAgentString(MiUserAgent);
    MiWebView.addJavascriptInterface(new JSInterface(this), "Android");

    MiWebView.setWebViewClient(new WebViewClient() {
      @TargetApi(android.os.Build.VERSION_CODES.M)

      @Override
      public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
        onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
      }
    });
   
    MiWebView.loadUrl("file:///android_asset/index.html");
    setContentView(MiWebView);
  }


  @Override
  public void onBackPressed() {
    if (MiWebView.canGoBack()) {
      MiWebView.goBack();
    } else {
      super.onBackPressed();
    }
  }

}
