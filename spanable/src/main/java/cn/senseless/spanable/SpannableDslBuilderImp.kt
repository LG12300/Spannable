package cn.senseless.spanable

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.style.*
import android.view.View

/**
 * 包装SpannableStringBuilder，对此类设置的属性对内部所有生效
 * @author lig
 * @date 2022-03-22
 */
class SpannableDslBuilderImp internal constructor() : SpannableDsl() {
    override val source = SpannableStringBuilder()

    override fun bold() {
        source.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }


    override fun italic() {
        source.setSpan(
            StyleSpan(Typeface.ITALIC),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun normal() {
        source.setSpan(
            StyleSpan(Typeface.NORMAL),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun boldItalic() {
        source.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun size(sp: Int) {
        source.setSpan(
            AbsoluteSizeSpan(sp, true),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun color(color: Int) {
        source.setSpan(
            ForegroundColorSpan(color),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun backgroundColor(color: Int) {
        source.setSpan(
            BackgroundColorSpan(color),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun onClick(block: () -> Unit) {
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
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun strikethrough() {
        source.setSpan(
            StrikethroughSpan(),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    override fun underline() {
        source.setSpan(
            UnderlineSpan(),
            0,
            source.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
    }

    fun append(charSequence: CharSequence) {
        source.append(charSequence)
    }

    fun span(text: String, block: SpannableDsl.() -> Unit = {}) {
        val gnSpannableString = SpannableDslImp(text).apply(block)
        append(gnSpannableString.source)
    }
}