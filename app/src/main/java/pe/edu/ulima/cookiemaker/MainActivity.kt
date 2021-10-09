package pe.edu.ulima.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.fragments.RecipeListFragment
import pe.edu.ulima.cookiemaker.fragments.RecipeRegistrationFragment
import pe.edu.ulima.cookiemaker.fragments.SelectIngredientFragment
import pe.edu.ulima.cookiemaker.model.Ingrediente

class MainActivity : AppCompatActivity(), RecipeRegistrationFragment.OnButtonClicked, SelectIngredientFragment.OnIngredientSelectedListener {
   private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getBundleExtra("data")?.getString("username").toString()

        fragments.add(RecipeRegistrationFragment(username))
        fragments.add(SelectIngredientFragment())
        fragments.add(RecipeListFragment())

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, fragments[0])

        ft.commit()
    }

    private fun changeRecipeRegistrationFragment(ingredient : Ingrediente) {
        val bundle = Bundle()
        bundle.putString("ingredient", ingredient.nombre)
        val fragment = fragments[0]
        fragment.arguments = bundle
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

    private fun changeRecipeListFragment() {
        val fragment = fragments[2]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    //Checks which button is being pressed and changes the fragment accordingly
    override fun onClick(button: String) {
        if (button == "ingredients") {
            changeSelectIngredientFragment()
        }else if (button == "recipe_details"){
            changeRecipeListFragment()
        }
    }

    override fun onSelect(ingredient: Ingrediente) {

        Log.i("IngredientsFragment", "Click")
        changeRecipeRegistrationFragment(ingredient)
    }
}