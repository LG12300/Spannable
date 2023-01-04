package cn.senseless.spanable

/**
 * 包装SpannableString和SpannableStringBuilder，
 * 不需要去记各个Span类，同时支持DSL写法
 * 示例：
 * tvText.text = spannableStringBuilder {
 *     size(16)
 *     span("Hello") {
 *         bold()
 *         color(Color.BLUE)
 *     }
 *     append(" ")
 *     span("World") {
 *         italic()
 *         color(Color.RED)
 *     }
 * }
 */
fun buildSpannableString(block: SpannableDslBuilderImp.() -> Unit): CharSequence {
    val gnSpannableStringBuilder = SpannableDslBuilderImp().apply(block)
    return gnSpannableStringBuilder.source
}

fun spanString(text: String, block: SpannableDsl.() -> Unit = {}): CharSequence {
    val gnSpannableString = SpannableDslImp(text).apply(block)
    return gnSpannableString.source
}