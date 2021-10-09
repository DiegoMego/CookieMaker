package pe.edu.ulima.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.fragments.RecipeDetailsFragment
import pe.edu.ulima.cookiemaker.fragments.RecipeListFragment
import pe.edu.ulima.cookiemaker.fragments.RecipeRegistrationFragment
import pe.edu.ulima.cookiemaker.fragments.SelectIngredientFragment
import pe.edu.ulima.cookiemaker.model.Ingrediente
import pe.edu.ulima.cookiemaker.model.Receta
import pe.edu.ulima.cookiemaker.shared.*

/*
Integrantes:
   IZAGUIRRE CASTRO ANDONI TOMAS (20142881)
   MEGO FERNANDEZ DIEGO ALONSO (20100696)

   REPOSITORIO: https://github.com/DiegoMego/CookieMaker
* */

class MainActivity : AppCompatActivity(), RecipeListFragment.OnRecipeSelectListener, RecipeRegistrationFragment.OnButtonClicked, SelectIngredientFragment.OnIngredientSelectedListener {
   private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getBundleExtra("data")?.getString("username").toString()

        fragments.add(RecipeListFragment())
        fragments.add(RecipeRegistrationFragment(username))
        fragments.add(SelectIngredientFragment())
        fragments.add(RecipeDetailsFragment())

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, fragments[RecipeListView])

        ft.commit()
    }

    private fun changeRecipeRegistrationFragment(ingredient : Ingrediente) {
        val bundle = Bundle()
        bundle.putString("ingredient", ingredient.nombre)
        val fragment = fragments[RecipeRegistrationView]
        fragment.arguments = bundle
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

     private fun changeSelectIngredientFragment() {
        val fragment = fragments[SelectIngredientView]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    private fun changeRecipeListFragment() {
        val fragment = fragments[RecipeListView]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    private fun changeRecipeRegistrationFragment() {
        val fragment = fragments[RecipeRegistrationView]
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

        changeRecipeRegistrationFragment(ingredient)
    }

    fun ChangeToRecipeDetails(receta: Receta){
        //Implement change to recipe details fragment
        val bundle = Bundle()
        bundle.putString("RecipeId", receta.id.toString())
        val fragment = fragments[RecipeDetailsView]
        fragment.arguments = bundle
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    override fun OnSelect(receta: Receta) {
        ChangeToRecipeDetails(receta)
    }

    override fun OnAddRecipeClick() {
        changeRecipeRegistrationFragment()
    }
}