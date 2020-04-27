package com.winechitpaing.myamnarphonenumber.normalizer

import com.winechitpaing.myamnarphonenumber.rule.EnglishNumberRule
import com.winechitpaing.myamnarphonenumber.rule.SanitizeRule
import com.winechitpaing.myamnarphonenumber.rule.ZeroNineRule


class MyanmarPhoneNumberNormalizer(
  private val ruleList: List<Rule> = listOf(
    SanitizeRule(),
    EnglishNumberRule(),
    ZeroNineRule()
  )
) {

  class Builder() {

    private var ruleList = mutableListOf<Rule>()

    fun addRule(rule: Rule) {
      ruleList.add(rule)
    }

    fun build(): MyanmarPhoneNumberNormalizer {
      return MyanmarPhoneNumberNormalizer(ruleList.toList())
    }

  }

  fun normalize(phoneNumber: String): String {
    var normalizedString = phoneNumber

    ruleList.forEach {
      normalizedString = it.convert(normalizedString)
    }

    return normalizedString
  }


}