package pe.edu.ulima.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecipeRegistrationActivity : AppCompatActivity() {
    private lateinit var eteRecipe : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_registration)

        eteRecipe = findViewById(R.id.editText_Recipe)

        val butSave : Button = findViewById(R.id.button_Save)
        butSave.setOnClickListener { _ : View ->
            if (eteRecipe!!.text.toString() == "") {
                Toast.makeText(this, "Ingrese una receta, por favor", Toast.LENGTH_LONG).show()
            }else {
                //Pasar a otro activity
                val intent : Intent = Intent()
                intent.setClass(this, RecipeListActivity::class.java)
                startActivity(intent)
            }
        }
        val butIngredients : Button = findViewById(R.id.button_Ingredients)
        butIngredients.setOnClickListener { _: View ->
            //Pasar a otro activity
            val intent : Intent = Intent()
            intent.setClass(this, SelectIngredientActivity::class.java)
            startActivity(intent)
        }
    }
}