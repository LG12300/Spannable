安卓富文本框架，用dsl方式拼接富文本

simple:
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