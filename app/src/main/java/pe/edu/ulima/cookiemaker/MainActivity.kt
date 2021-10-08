package pe.edu.ulima.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.fragments.RecipeListFragment
import pe.edu.ulima.pm.ulgamestore.model.Receta

class MainActivity : AppCompatActivity(), RecipeListFragment.OnRecipeSelectListener {
    private var fragments: ArrayList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RecipeListFragment())
    }

    fun ChangeToRecipeDetails(receta: Receta){
        //Implement change to recipe details fragment
    }

    override fun OnSelect(receta: Receta) {
        ChangeToRecipeDetails(receta)
    }
}