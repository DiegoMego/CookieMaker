package pe.edu.ulima.cookiemaker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        recipeId = this.arguments?.get("RecipeId").toString().toInt()
        return inflater.inflate(R.layout.fragment_recipe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeName : TextView = view.findViewById(R.id.tviRecipeName)
        val rviRecipeList : RecyclerView = view.findViewById(R.id.rviIngredientsList)
        val recipe : Receta? = RecetasManager().getInstance().getReceta(recipeId)
        recipeName.text = recipe?.nombre
        rviRecipeList.adapter = RecipeDetailsAdapter(recipe!!.ingredientes)
    }
}