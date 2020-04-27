package com.winechitpaing.myamnarphonenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.winechitpaing.myamnarphonenumber.normalizer.MyanmarPhoneNumberNormalizer
import com.winechitpaing.myamnarphonenumber.rule.SanitizeRule
import com.winechitpaing.myamnarphonenumber.rule.ZeroNineRule
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val zeroNineRule = ZeroNineRule()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCheck.setOnClickListener {
            getNormalizeResult()
        }
    }
    private fun getNormalizeResult(){
        val input = etMobileNumber.text.toString()

        val actual = zeroNineRule.convert(input)
        tvMobileNumber.text = actual

        val operator = MyanmarPhoneNumberUtils.getTelecomOperator(input)
        tvOperator.text = operator.name

        val networkType = MyanmarPhoneNumberUtils.getNetworkType(input)
        tvNetworkType.text = networkType.name
    }
}
