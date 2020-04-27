package com.winechitpaing.myamnarphonenumber.rule

import com.winechitpaing.myamnarphonenumber.normalizer.Rule


/**
 * Transform Burmese number to English number (e.g "၃၀" -> "30")
 */
class EnglishNumberRule : Rule {

  override fun convert(input: String): String {
    val eng = StringBuilder(input.length)

    input.forEach {
      if (it in '၀'..'၉') {
        eng.append((it.toInt() - 4112).toChar())
      } else {
        eng.append(it)
      }
    }

    return eng.toString()
  }

}

