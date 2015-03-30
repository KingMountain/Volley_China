package com.example.volleytest;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mImageView;
	private RequestQueue mRequestQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mImageView = (ImageView) this.findViewById(R.id.image);

		// 初始化一个请求队列
		mRequestQueue = Volley.newRequestQueue(this);

		// 请求图片的例子，可以在Response中做UI操作
		String url = "https://www.baidu.com/img/bdlogo.png";
		ImageRequest mImageRequest = new ImageRequest(url,
				new Response.Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						mImageView.setImageBitmap(response);
					}

				}, 1000, 1000, Config.ARGB_8888, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {

					}
				});
		// 最好在添加 Request的时候能够 setTag，因为移除 Request的时候是根据这个Tag的值来移除的
		mImageRequest.setTag("Image");
		mRequestQueue.add(mImageRequest);
	}

	@Override
	protected void onDestroy() {
		mRequestQueue.cancelAll("Image");
	}
}
