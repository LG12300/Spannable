package cn.senseless.spannable

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.senseless.spanable.buildSpannableString

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}