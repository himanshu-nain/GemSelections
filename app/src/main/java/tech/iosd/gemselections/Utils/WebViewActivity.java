package tech.iosd.gemselections.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String _parent;
    //private Class parent;
    //private Toolbar toolbar;
    private String _URL;
    private ProgressBar progressBar;
    private boolean loadingFinished = true;
    private boolean redirect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_web_view);

        /*toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        progressBar = (ProgressBar)findViewById(tech.iosd.gemselections.R.id.webview_progressBar);

        webView = (WebView)findViewById(tech.iosd.gemselections.R.id.webview);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webView.setVisibility(View.GONE);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urlNew) {
                if(!loadingFinished){
                    redirect = true;
                }
                loadingFinished = false;
                view.loadUrl(urlNew);

                //getSupportActionBar().setTitle(urlNew);

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                loadingFinished = false;
                if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(!redirect){
                    loadingFinished = true;
                }

                //getSupportActionBar().setTitle(url);

                if(loadingFinished && !redirect){
                    progressBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }else {
                    redirect = false;
                }
            }
        });
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);

        if(getIntent().getExtras() != null){
            _URL = getIntent().getStringExtra("URL");
            //_parent = getIntent().getStringExtra("parent");
            /*try {
                //parent = Class.forName(_parent);
            } catch (ClassNotFoundException e) {
                //parent = MainActivity.class;
                e.printStackTrace();
            }*/
        }else {
             Snackbar.make(getCurrentFocus(), "Valid URL not found. Opening Khanna Gems", Snackbar.LENGTH_SHORT).show();
            _URL = "http://khannagems.com";
            //parent = MainActivity.class;
        }
        webView.loadUrl(_URL);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.home:
                //test
                Toast.makeText(getApplicationContext(), "Home CLICKED", Toast.LENGTH_SHORT).show();
                    startActivity(
                            new Intent(WebViewActivity.this, parent)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK)
                    );
                break;

            case R.id.reload_url:
                    webView.loadUrl(_URL);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webview, menu);
        return true;
    }
*/
}
