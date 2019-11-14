package com.example.webviewtest001;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebview;
    private WebSettings mWebssettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView mWebview=(WebView) findViewById(R.id.webview);;
        WebSettings mWebssettings;

        //mWebview.setWebViewClient(new WebViewClient());//클릭스 새창 뜨지 않게
        //mWebssettings = mWebview.getSettings();//웹뷰에 세팅 등록
        //mWebssettings.setSupportMultipleWindows(false);//페이지 자바스크립트 허용 여부
        //mWebssettings.setJavaScriptCanOpenWindowsAutomatically(false);//자바스크립트 새창 열기 여부
        //mWebssettings.setLoadWithOverviewMode(true);//메타태그허용 여부
        //mWebssettings.setUseWideViewPort(true);//화면사이즈 맞춤 여부
        //mWebssettings.setSupportZoom(false);//화면
        //mWebssettings.setBuiltInZoomControls(true);//화면 확대축소
        //mWebssettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//컨텐츠사이즈 맞춤
        //mWebssettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//브라우저 캐시 허용
        //mWebssettings.setDomStorageEnabled(true);//로컬저장 허용

        //mWebview.loadUrl("https://chatbotdev.kyobo.co.kr");
        mWebview.loadUrl("https://github.com/leejeeyong");
        //mWebview.loadUrl("https://google.com");
        //mWebview.getUrl();

    }

}
