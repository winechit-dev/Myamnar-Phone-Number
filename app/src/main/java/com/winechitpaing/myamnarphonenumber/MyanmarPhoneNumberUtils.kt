package com.winechitpaing.myamnarphonenumber


object MyanmarPhoneNumberUtils {

  /**
   * Check if [phoneNumber] is a valid myanmar phone number in English
   */
  fun isValidMyanmarPhoneNumber(phoneNumber: String): Boolean {

    val myanmarPhoneNumberRegex = Regex("^(09|\\+?950?9|\\+?95950?9)\\d{7,9}\$")

    return myanmarPhoneNumberRegex.matches(phoneNumber)
  }


  fun getTelecomOperator(phoneNumber: String): Operator {

    if (isValidMyanmarPhoneNumber(phoneNumber)) {

      Operator.values().forEach {

        if (it.regex.matches(phoneNumber)) {
          return it
        }
      }

    }

    return Operator.UNKNOWN

  }


  fun getNetworkType(phoneNumber: String): NetworkType {

    if (isValidMyanmarPhoneNumber(phoneNumber)) {

      //All of these operators uses only GSM
      if (Operator.OOREDOO.regex.matches(phoneNumber) ||
        Operator.TELENOR.regex.matches(phoneNumber) ||
        Operator.MYTEL.regex.matches(phoneNumber)
      ) {

        return NetworkType.GSM
      } else if (Operator.MPT.regex.matches(phoneNumber)) {

        NetworkType.values().forEach {
          if (it.regex.matches(phoneNumber)) {
            return it
          }
        }

        return NetworkType.GSM
      }

    }

    return NetworkType.UNKNOWN

  }

}