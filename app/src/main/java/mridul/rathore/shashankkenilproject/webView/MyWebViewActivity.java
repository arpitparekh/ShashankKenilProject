package mridul.rathore.shashankkenilproject.webView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import mridul.rathore.shashankkenilproject.databinding.ActivityMyWebViewBinding;

public class MyWebViewActivity extends AppCompatActivity {
    private ActivityMyWebViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://www.tops-int.com/");

//        binding.webView.loadUrl("file:///android_asset/myHtml.html");

        binding.webView.setWebViewClient(new MyWebViewClient());

    }

    class MyWebViewClient extends WebViewClient{

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            binding.pbLoading.setVisibility(View.GONE);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            binding.pbLoading.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onBackPressed() {

        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            super.onBackPressed();

        }

    }

}