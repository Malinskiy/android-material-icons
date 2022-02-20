[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.malinskiy/materialicons/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.malinskiy/materialicons) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-android--material--icons-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1173)

> **[All available icons (744)](http://zavoloklom.github.io/material-design-iconic-font/icons.html)**

**If, like me, you're tired of copying 5 images (ldpi, mdpi, hdpi, xhdpi, xxhdpi) for each icon you want to use in your app, for each color you want to use them with ```android-material-icons``` can help you.**

-----

### About

**android-material-icons** allows you to include any of the **[Material Design 2.1.1 icons by Google packed by Sergey Kupletsky](http://zavoloklom.github.io/material-design-iconic-font/)** in your texts, your ```ActionBar```, and even in your ```EditText```s. Icons are infinitely **scalable**, and **customizable** with shadows and everything you can do on texts.

Special thanks to **Joan Zapata** for his [android-iconify](https://github.com/JoanZapata/android-iconify) project since this is mostly a copy :)

### Get started #1

If you need icons on a ```TextView```, use the ```{ }``` syntax. You can put any text around it and have more than one icon in the text. Note that the shadows apply to the icons as well.

```xml
<IconTextView
    android:text="{zmdi-android}"
    android:shadowColor="#22000000"
    android:shadowDx="3"
    android:shadowDy="3"
    android:shadowRadius="1"
    android:textSize="90dp"
    android:textColor="#FF33B5E5"
    ... />
```

> You can either use ```IconTextView``` / ```IconButton``` or use any ```TextView``` and then programmatically call ```Iconify.addIcons(myTextView);```.

### Get started #2

If you need an icon in an ```ImageView``` or in your ```ActionBar```, then you should use ```IconDrawable```. Again, icons are infinitely scalable and will never get fuzzy!

```java
// Set an icon in the ActionBar
menu.findItem(R.id.share).setIcon(
   new IconDrawable(this, IconValue.zmdi_share)
   .colorRes(R.color.ab_icon)
   .actionBarSize());
```

### Design-time preview (```maybe working```)
1. Copy material font [file](https://github.com/Malinskiy/android-material-icons/blob/master/android-material-icons/src/main/resources/material-design-iconic-font-2.1.1.ttf) (do not rename it) to your ```$ANDROID_SDK/platforms/android-$N/data/fonts/``` folder for each platform ```$N``` available.
2. Assign attribute ```hacky_preview``` like this:
```xml
<com.malinskiy.materialicons.widget.IconTextView
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="{zmdi-android}"
            android:textSize="48dp"
            app:hacky_preview="true"/>
```

-----

## Get it

Gradle:
```groovy
repositories {
    ...
    mavenCentral()
    ...
}
...
dependencies {
    ...
    implementation 'com.malinskiy:materialicons:1.0.2'
    ...
}
```

## License

```
Copyright 2013 Joan Zapata
Copyright 2014 Anton Malinskiy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

It uses Google's material font licensed under OFL 1.1, which is compatible
with this library's license.

    http://scripts.sil.org/cms/scripts/render_download.php?format=file&media_id=OFL_plaintext&filename=OFL.txt
    
```
