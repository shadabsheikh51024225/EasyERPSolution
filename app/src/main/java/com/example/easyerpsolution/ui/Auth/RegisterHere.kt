package com.example.easyerpsolution.ui.Auth

import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityRegisterHereBinding


class RegisterHere : AppCompatActivity() {
    private var successPassword: Boolean = false
    private var successConfirmPassword: Boolean = false
    private var successEmail: Boolean = false
    private var successUserName: Boolean = false
    private var handler: Handler? = null
    private lateinit var binding: ActivityRegisterHereBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterHereBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }
        binding.textViewLogInHere.setOnClickListener {
            val i = Intent(this, LogInActivity::class.java)
            startActivity(i)
            finish()
        }

        binding.registerHere.setOnClickListener {

            getPassword(
                binding.editTextTextPassword.text.toString(),
                binding.editTextTextPassword.text?.length!!.toInt()
            )
            getUserName(
                binding.editTextTextUserName.text.toString(),
                binding.editTextTextUserName.text?.length!!.toInt()
            )
            getEmail(
                binding.editTextEmail.text.toString(),
                binding.editTextEmail.text?.length!!.toInt()
            )
            getConfirmPassword(
                binding.editTextTextConfirmPassword.text.toString()
            )

            if (successPassword && successConfirmPassword && successEmail && successUserName) {
                generateSuccessDialog()
            }


        }

    }

    private fun getPassword(PasswordText: String, LengthOfText: Int) {

        if (PasswordText.isEmpty()) {
            binding.textInputLayoutPassword.error = "Invalid Password"
        } else if (LengthOfText <= 7) {
            binding.textInputLayoutPassword.error = " Password can not be less than 8 digits"
        } else {
            binding.textInputLayoutPassword.error = null
            successPassword = true
        }
    }

    private fun getUserName(UsernameText: String, LengthOfText: Int) {
        if (UsernameText.isEmpty()) {
            binding.textInputLayoutUserName.error = "Invalid UserName"
        } else if (LengthOfText <= 3) {
            binding.textInputLayoutUserName.error = " Username can not be less than 4 digits"
        } else {
            binding.textInputLayoutUserName.error = null
            successUserName = true
        }
    }

    private fun getEmail(emailText: String, LengthOfText: Int) {
        if (emailText.isEmpty()) {
            binding.textInputLayoutEmail.error = "   Invalid Email"
        } else if (!isValidEmail(emailText)) {
            binding.textInputLayoutEmail.error = "   Please enter a valid email"
        } else {
            binding.textInputLayoutEmail.error = null
            successEmail = true
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    private fun isValidPassword(target: CharSequence?, matchTarget: CharSequence?): Boolean {

        return target.contentEquals(matchTarget)
    }

    private fun getConfirmPassword(confirmPasswordText: String) {
        if (confirmPasswordText.isEmpty()) {
            binding.textInputLayoutConfirmPassword.error = "Invalid Password"
        } else if (!isValidPassword(confirmPasswordText, binding.editTextTextPassword.text)) {
            binding.textInputLayoutConfirmPassword.error = " Password doesn't match"
        } else {
            binding.textInputLayoutConfirmPassword.error = null
            successConfirmPassword = true
        }
    }

    private fun generateSuccessDialog() {
        val dialog = Dialog(this@RegisterHere)
        dialog.setContentView(R.layout.register_success_dialog_layout)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.window?.attributes?.windowAnimations = R.style.dialogAnimation
        dialog.show()
        Handler().postDelayed({
            if (dialog.isShowing) {
                dialog.dismiss()
                finish()
            }
        }, 2000)

    }


}
