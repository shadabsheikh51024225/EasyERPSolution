package com.example.easyerpsolution.Final.PaymnetMethod

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.CompoundButton
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityPaymentMethodsBinding

class PaymentMethods : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityPaymentMethodsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  setSupportActionBar(findViewById(R.id.main_tool_bar))
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        binding.creditCardDebitCardRedio.setOnCheckedChangeListener(this)
        binding.cashOnDeliveryRadio.setOnCheckedChangeListener(this)
        binding.payPalRadioBtn.setOnCheckedChangeListener(this)

    }



    override fun onCheckedChanged(buttonView: CompoundButton?, isCheckedradio: Boolean) {
        if (isCheckedradio) {
            if (R.id.credit_card_debit_card_redio == buttonView?.id) {
                binding.cashOnDeliveryRadio.isChecked =false
                binding.payPalRadioBtn.isChecked = false

            } else if (R.id.cash_on_delivery_radio == buttonView?.id) {
                binding.creditCardDebitCardRedio.isChecked = false
                binding.payPalRadioBtn.isChecked = false
            } else {

                binding.creditCardDebitCardRedio.isChecked = false
                binding.cashOnDeliveryRadio.isChecked = false
            }
        }
    }




}