package com.dt.sharath.quickcognizant;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MyActivity extends Activity {

                         private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


                         mWebView = (WebView) findViewById(R.id.wv);

                        WebSettings webSettings = mWebView.getSettings();
                        webSettings.setJavaScriptEnabled(true);


                        mWebView.getSettings().setBuiltInZoomControls(true);


                        mWebView.loadUrl("https://onecognizant.cognizant.com/");
                        // Force links and redirects to open in the WebView instead of in a browser
                        mWebView.setWebViewClient(new WebViewClient());
    }


                        @Override
                        public void onBackPressed() {
                            if(mWebView.canGoBack()) {
                                mWebView.goBack();
                            } else {
                                super.onBackPressed();
                            }
                        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

                                    Button refr;
        int id = item.getItemId();
        if (id == R.id.item_refresh) {
            return true;
        }


                                    refr = (Button) findViewById(R.id.item_refresh);
                                    refr.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            mWebView.loadUrl("https://onecognizant.cognizant.com/");
                                        }
                                    });

        return super.onOptionsItemSelected(item);


    }


}
