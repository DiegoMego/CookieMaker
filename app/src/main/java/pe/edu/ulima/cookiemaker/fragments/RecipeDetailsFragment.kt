package pe.edu.ulima.cookiemaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.adapter.RecipeDetailsAdapter
import pe.edu.ulima.cookiemaker.adapter.RecipeListAdapter
import pe.edu.ulima.cookiemaker.model.Receta
import pe.edu.ulima.cookiemaker.model.RecetasManager

class RecipeDetailsFragment : Fragment() {
    private var recipeId : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_details, container, false)
        recipeId = arguments?.getInt("RecipeId", 0)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rviRecipeList : RecyclerView = view.findViewById(R.id.rviIngredientsList)
        val recipe : Receta? = RecetasManager().getInstance().getReceta(recipeId)
        rviRecipeList.adapter = RecipeDetailsAdapter(recipe!!.ingredientes)
    }
}