package com.example.easyerpsolution.Final.Auth.LogIn

import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.easyerpsolution.Final.Auth.Register.RegisterHere
import com.example.easyerpsolution.Final.Auth.Register.RegisterHereViewModel
import com.example.easyerpsolution.Final.Auth.Register.RegisterUserDataModel
import com.example.easyerpsolution.Final.Auth.Register.UserResponseRegister
import com.example.easyerpsolution.Final.MainActivity
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityLogInBinding
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    private lateinit var viewModel: LogInViewModel
    private lateinit var binding: ActivityLogInBinding
    private var successPasswordLogIn: Boolean = false
    private var successUserNameLogIn: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewModel()
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        binding.forgotPasswordTextView.setOnClickListener {
            generateForgotPasswordDialog()
        }
        binding.buttonLogInAccess.setOnClickListener {
            getUserNameLogIn(
                binding.editTextTextUserNameLogIn.text.toString(),
                binding.editTextTextUserNameLogIn.text?.length!!.toInt()
            )
            getPasswordLogIn(
                binding.editTextTextPasswordLogIn.text.toString(),
                binding.editTextTextPasswordLogIn.text?.length!!.toInt()
            )
            if (successPasswordLogIn && successPasswordLogIn) {
                createUser( binding.editTextTextUserNameLogIn.text.toString(), binding.editTextTextPasswordLogIn.text.toString())
            }

        }
        binding.textViewRegisterHere.setOnClickListener() {
            val i = Intent(this, RegisterHere::class.java)
            startActivity(i)
        }
    }
    private fun createUser(email:String,password:String) {
        val user  = LogInUserDataModel(email,password)
        viewModel.LogInUser(user)

    }


    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponseLogIn?>{

            if(it  == null) {
                Toast.makeText(this@LogInActivity, "Not a valid entry", Toast.LENGTH_SHORT).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
              //  Toast.makeText(this@LogInActivity, "success to create User", Toast.LENGTH_LONG).show()
                generateSuccessDialogLogIn()
            }
        })
    }

    private fun getPasswordLogIn(PasswordText: String, LengthOfText: Int) {

        if (PasswordText.isEmpty()) {
            binding.textInputLayoutPasswordLogIn.error = "Invalid Password"
        } else if (LengthOfText <= 7) {
            binding.textInputLayoutPasswordLogIn.error = " Password can not be less than 8 digits"
        } else {
            binding.textInputLayoutPasswordLogIn.error = null
            successPasswordLogIn = true
        }
    }

    private fun getUserNameLogIn(UsernameText: String, LengthOfText: Int) {
        if (UsernameText.isEmpty()) {
            binding.textInputLayoutUserNameLogIn.error = "Invalid UserName"
        } else if (LengthOfText <= 3) {
            binding.textInputLayoutUserNameLogIn.error = " Username can not be less than 4 digits"
        } else {
            binding.textInputLayoutUserNameLogIn.error = null
            successUserNameLogIn = true
        }
    }

    private fun generateSuccessDialogLogIn() {
        val dialog = Dialog(this@LogInActivity)
        dialog.setContentView(R.layout.register_success_dialog_layout)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.window?.attributes?.windowAnimations = R.style.dialogAnimation
        dialog.window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
        val successTextDialog: TextView = dialog.findViewById(R.id.successDialogText)
        successTextDialog.text = "Log In SuccessFully..."
        dialog.show()
        Handler().postDelayed({
            if (dialog.isShowing) {

                dialog.dismiss()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }, 1500)

    }

    private fun generateForgotPasswordDialog() {
        val dialog = Dialog(this@LogInActivity)
        dialog.setContentView(R.layout.forgot_password_dialog)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.window?.attributes?.windowAnimations = R.style.dialogAnimation
        dialog.window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
        var buttonSendForgotPassword: Button = dialog.findViewById(R.id.button_send_forgot_password)
        var editTextForgotPassword: EditText = dialog.findViewById(R.id.editTextEmailForgotPassword)
        var textInputLayoutForgotPassword: TextInputLayout =
            dialog.findViewById(R.id.textInputLayoutEmailForgotPassword)
        dialog.show()
        if (dialog.isShowing) {
            buttonSendForgotPassword.setOnClickListener {
                if (editTextForgotPassword.text.isEmpty()) {
                    textInputLayoutForgotPassword.error = "   Invalid Email"
                } else if (!isValidEmail(editTextForgotPassword.text)) {
                    textInputLayoutForgotPassword.error = "   Please enter a valid email"
                } else {
                    textInputLayoutForgotPassword.error = null
                    dialog.dismiss()
                }
            }
        }

    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

}