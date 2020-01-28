package android.example.com

import android.content.Context
import android.example.com.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Dragon Lung")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickName(it)
        //}

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
            //nickname_text.text = nickname_edit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nickname_edit.visibility = View.GONE
            done_button.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
        }

        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
