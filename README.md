Activity 투명도

styles.xml
```
  <!-- Activity 투명도 핵심 -->
    <style name="AppTheme.Transfer" parent="@style/Theme.AppCompat">
        <!--Titlebar 없애는 옵션
       true : Titlebar x
       false : Titlebar o
        -->
        <item name="windowNoTitle">false</item>
        <!-- 투명정도를 나타내는 색-->
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:colorBackgroundCacheHint">@null</item>
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowAnimationStyle">@android:style/Animation</item>
        <!--
        android:backgroundDimEnabled
        true - 반투명 검정 /  false - 완전 투명
        -->
        <item name="android:backgroundDimEnabled">true</item>
    </style>
```

Androidmanifest.xml
```
android:theme="@style/AppTheme.Transfer"
```

투명으로 나타낼 Activity
```
android:background="@android:color/transparent"
```
