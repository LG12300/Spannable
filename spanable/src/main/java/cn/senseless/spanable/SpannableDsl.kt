package cn.senseless.spanable

import android.graphics.Typeface
import android.text.Spannable
import android.text.TextPaint
import android.text.style.*
import android.view.View

/**
 *
 * @author lig
 * @date 2022-03-24
 */
abstract class SpannableDsl {
    abstract val source: Spannable

    open fun bold() {
        source.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }


    open fun italic() {
        source.setSpan(
            StyleSpan(Typeface.ITALIC),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun normal() {
        source.setSpan(
            StyleSpan(Typeface.NORMAL),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun boldItalic() {
        source.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun size(sp: Int) {
        source.setSpan(
            AbsoluteSizeSpan(sp, true),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun color(color: Int) {
        source.setSpan(
            ForegroundColorSpan(color),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun backgroundColor(color: Int) {
        source.setSpan(
            BackgroundColorSpan(color),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun onClick(block: () -> Unit) {
        source.setSpan(
            object : ClickableSpan() {

                override fun onClick(widget: View) {
                    block()
                }

                override fun updateDrawState(ds: TextPaint) {
                }
            },
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun strikethrough() {
        source.setSpan(
            StrikethroughSpan(),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    open fun underline() {
        source.setSpan(
            UnderlineSpan(),
            0,
            source.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}