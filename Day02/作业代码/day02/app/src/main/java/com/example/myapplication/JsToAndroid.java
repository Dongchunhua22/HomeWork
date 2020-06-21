package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;


class JsToAndroid {
     private MainActivity mContext;
     private ImageView mMineTpHead;
     private PhotoPopupWindow mPhotoPopupWindow;
     //拍照或选择图片并切割
     private static final int REQUEST_IMAGE_GET = 0;
     private static final int REQUEST_IMAGE_CAPTURE = 1;
     private static final int REQUEST_SMALL_IMAGE_CUTTING = 2;
     private static final String IMAGE_FILE_NAME = "icon.jpg";

     public JsToAndroid(MainActivity context) {
         this.mContext = context;
     }
 @JavascriptInterface
    public  void  hllo(String msg){
        Log.e("TAG", msg );
    /* Intent intent = new Intent();
     intent.setAction(Intent.ACTION_PICK);
     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    // MainActivity.this. startActivityForResult(intent,0);
     mContext.startActivityForResult(intent,200);*/


 }
}
