package com.winechitpaing.myamnarphonenumber.rule

import com.winechitpaing.myamnarphonenumber.normalizer.Rule


/**
 * Rule to convert to +959-XXXXXXXXX format.
 * This accept only English numerals
 */
class ZeroNineRule : Rule {

  private val possibleCases = Regex("(09)|(09-)|(\\+959)|(09\\s)|(959)|(09\\.)")

  override fun convert(input: String): String {

    if (possibleCases.containsMatchIn(input)) {
      return input.replaceFirst(possibleCases, "+959")
    }

    return input
  }

}