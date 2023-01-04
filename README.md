## 安卓富文本框架，用dsl方式拼接富文本

```
val textView = findViewById<TextView>(R.id.text)
textView.text = buildSpannableString {
    span("Hello") {
        color(Color.RED)
        size(14)
    }
    append(" ")
    span("World") {
        color(Color.BLUE)
        size(18)
        bold()
    }
}
```

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency
[![](https://jitpack.io/v/senseless00/Spannable.svg)](https://jitpack.io/#senseless00/Spannable)
```groovy
	dependencies {
	        implementation 'com.github.senseless00:Spannable:Tag'
	}
```