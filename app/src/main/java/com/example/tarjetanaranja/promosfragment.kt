package com.example.tarjetanaranja


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * A simple [Fragment] subclass.
 *
 */
class promosfragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_promosfragment, container, false)
        var mWebView: WebView
        mWebView = view.findViewById(R.id.webview2) as WebView
        mWebView.loadUrl("https://www.naranja.com/para-vos/promociones")

        // Enable Javascript
        var webSettings = mWebView.settings
        webSettings.setJavaScriptEnabled(true)

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.webViewClient = WebViewClient()
        return view
    }

    companion object {
        fun newInstance(): promosfragment = promosfragment()
    }

}
