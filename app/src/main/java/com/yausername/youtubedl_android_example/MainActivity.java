package com.yausername.youtubedl_android_example;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.yausername.youtubedl_android.YoutubeDL;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private ImageButton btnStreamingExample;
    private ImageButton btnDownloadingExample;
    private ProgressBar progressBar;

    TextInputEditText etUrl;
    private boolean updating = false;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownloadingExample = findViewById(R.id.btn_downloading_example);
        btnStreamingExample = findViewById(R.id.btn_streaming_example);
        etUrl = findViewById(R.id.etUrl);

        String url = etUrl.getText().toString().trim();
        btnStreamingExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                if (TextUtils.isEmpty(url)) {
                    etUrl.setError(getString(R.string.url_error));

                }
                else{
                    Intent i = new Intent(MainActivity.this, StreamingExampleActivity.class);
                    i.putExtra("Url",url);
                    startActivity(i);
                }
            }
        });


        btnDownloadingExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();
                if (TextUtils.isEmpty(url)) {
                    etUrl.setError(getString(R.string.url_error));

                }
                else{
                    Intent i = new Intent(MainActivity.this, DownloadingExampleActivity.class);
                    i.putExtra("Url",url);
                    startActivity(i);
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }



}
