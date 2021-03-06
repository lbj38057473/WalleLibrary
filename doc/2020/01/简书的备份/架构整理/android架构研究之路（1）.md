归纳自己常用的第三方框架库
```
//zxing修复nexus5x倒立问题的库 https://github.com/bingoogolapple/BGAQRCode-Android
    implementation 'cn.bingoogolapple:bga-qrcode-zxing:1.3.6'

    //关于设置圆角的imageview，如果是用glide的话，就直接用glide控制
    implementation ("com.github.bumptech.glide:glide:3.7.0") {
        force true
    }
    //设置图片圆角角度
    //RoundedCorners roundedCorners= new RoundedCorners(6);
    //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
    //RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
    //Glide.with(context).load(files.getFilePath()).apply(options).into(mUserPhoto);

    //高度封装rv  https://github.com/CymChad/BaseRecyclerViewAdapterHelper
    implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.40'

    // 知乎图片选择框架
    implementation 'com.zhihu.android:matisse:0.5.2-beta2'

    //关于textview不支持html多个样式问题，考虑过用webview来处理
    //网上建议implementation 'androidx.core:core:1.0.1
    //HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY);
    //另外还有一个库 https://github.com/Pixplicity/HtmlCompat
    implementation 'com.pixplicity.htmlcompat:library:1.1.1'

    //实现右上角数字红点 https://github.com/jgilfelt/android-viewbadger
    implementation files('libs/android-viewbadger.jar')

    //实现文字折叠效果 https://github.com/Carbs0126/ExpandableTextView
    implementation 'cn.carbs.android:ExpandableTextView:1.0.3'

    //图片裁剪库 https://github.com/Yalantis/uCrop
    implementation 'com.github.yalantis:ucrop:2.2.2'

    //加载长图库 https://github.com/davemorrissey/subsampling-scale-image-view
    implementation(name: 'subsampling-scale-image-view-3.10.0', ext: 'aar')

    //用于判断root手机 https://github.com/scottyab/rootbeer
    implementation 'com.scottyab:rootbeer-lib:0.0.7'

    //pdf 预览库 https://github.com/moz1q1/AndroidPdfViewer
    implementation 'com.github.moz1q1:AndroidPdfViewer:3.1.0-beta.1'

    //实现图片缩放旋转 https://github.com/bm-x/PhotoView
    implementation 'com.bm.photoview:library:1.4.1'

    //评分的星星 https://github.com/ome450901/SimpleRatingBar
    implementation 'com.github.ome450901:SimpleRatingBar:1.4.3'

    //申请权限库 https://github.com/yanzhenjie/AndPermission
    // 也可以考虑他的图片选择库 https://github.com/yanzhenjie/Album
    implementation 'com.yanzhenjie.permission:support:2.0.1'

    //高仿ios的dialog 对话框 https://github.com/kongzue/DialogV3
    implementation 'com.kongzue.dialog_v3:dialog:3.0.9'
    
    //从底部往上滑的对话框 https://github.com/orhanobut/dialogplus
    implementation 'com.orhanobut:dialogplus:1.11@aar'
```
