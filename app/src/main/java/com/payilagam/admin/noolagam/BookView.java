package com.payilagam.admin.noolagam;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class BookView extends AppCompatActivity  {
    WebView webview;
    ProgressDialog pDialog;
    String file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);
       file = getIntent().getStringExtra("book");
          /*    PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
            pdfView.fromAsset(file).load();
    */
        init();
        listener();
    }

    private void init() {
        webview = (WebView) findViewById(R.id.bookview);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);

        //---you need this to prevent the webview from
        // launching another browser when a url
        // redirection occurs---
        webview.setWebViewClient(new Callback());





        pDialog = new ProgressDialog(BookView.this);
        pDialog.setTitle("BOOK");
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        webview.loadUrl("http://docs.google.com/gview?embedded=true&url="+file);

    }

    private void listener() {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pDialog.dismiss();
            }
        });
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            return (false);
        }
    }
}
