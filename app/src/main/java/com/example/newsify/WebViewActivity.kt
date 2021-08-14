package com.example.newsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url=intent.getStringExtra("URL")
        if(url!=null){
            webview.settings.javaScriptEnabled=true
            webview.settings.userAgentString="Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
           webview.webViewClient=object : WebViewClient() {
               override fun onPageFinished(view: WebView?, url: String?) {
                   super.onPageFinished(view, url)
                   webviewpgbar.visibility= View.GONE
                   webview.visibility=View.VISIBLE
               }
           }
            webview.loadUrl(url)
        }
    }
}