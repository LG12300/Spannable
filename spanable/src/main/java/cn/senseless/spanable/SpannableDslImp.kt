package cn.senseless.spanable

import android.text.SpannableString

/**
 * 包装SpannableString，对此类设置的属性只对自身生效
 * @author lig
 * @date 2022-03-22
 */
internal class SpannableDslImp(text: CharSequence) : SpannableDsl() {
    override val source: SpannableString = SpannableString(text)
}
