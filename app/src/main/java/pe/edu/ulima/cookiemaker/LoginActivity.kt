package pe.edu.ulima.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var eteName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        eteName = findViewById(R.id.editText_Name)

        val butLogin : Button = findViewById(R.id.button_Login)
        butLogin.setOnClickListener { _ : View ->
            if (eteName!!.text.toString() == "") {
                Toast.makeText(this, "Ingrese un nombre, por favor", Toast.LENGTH_LONG).show()
            }else {
                //Pasar a otro activity
                val intent : Intent = Intent()
                intent.setClass(this, RecipeListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}