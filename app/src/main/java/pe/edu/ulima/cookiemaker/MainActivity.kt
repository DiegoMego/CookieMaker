package pe.edu.ulima.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.fragments.RecipeRegistrationFragment
import pe.edu.ulima.cookiemaker.fragments.SelectIngredientFragment
import pe.edu.ulima.cookiemaker.model.Ingrediente

class MainActivity : AppCompatActivity(), RecipeRegistrationFragment.OnButtonClicked, SelectIngredientFragment.OnIngredientSelectedListener {
   private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RecipeRegistrationFragment())
        fragments.add(SelectIngredientFragment())
        //fragments.add(RecipeDetailsFragment())

        /*
        val username = intent.getBundleExtra("data")?.getString("username")
        findViewById<TextView>(R.id.tviUserName).text = username
         */

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, fragments[0])

        ft.commit()
    }

    private fun changeRecipeRegistrationFragment(ingredient : Ingrediente) {
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

     private fun changeSelectIngredientFragment() {
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    /*
    private fun changeRecipeDetailsFragment() {
        val ete_recipe_name = findViewById(R.id.editText_Name)
        if (ete_recipe_name!!.text.toString() == "") {
            Toast.makeText(this, "Ingrese un nombre para la receta, por favor", Toast.LENGTH_LONG).show()
        }else {
            val fragment = fragments[3]
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flaContent, fragment)

            ft.commit()
        }
    }
     */

    override fun onClick(button: String) {
        if (button == "ingredients") {
            changeSelectIngredientFragment()
        }else if (button == "recipe_details"){
            //
        }
    }

    override fun onSelect(ingredient: Ingrediente) {
        Log.i("IngredientsFragment", "Click")
        changeRecipeRegistrationFragment(ingredient)
    }
}