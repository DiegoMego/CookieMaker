package pe.edu.ulima.cookiemaker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.adapter.IngredientsListAdapater
import pe.edu.ulima.cookiemaker.model.Ingrediente
import pe.edu.ulima.cookiemaker.model.RecetasManager

class RecipeRegistrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rviRecipeRegis = view.findViewById<RecyclerView>(R.id.rviRecipeRegis)
        rviRecipeRegis.adapter =
            IngredientsListAdapater(
                RecetasManager().getIngredientes()
            )  { ingredient : Ingrediente ->
                Log.i("SelectIngredientFragment", ingredient.nombre)
            }
    }
}