package pe.edu.ulima.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.adapter.RecipeIngredientsAdapter
import pe.edu.ulima.cookiemaker.model.Ingrediente
import pe.edu.ulima.cookiemaker.model.Receta
import pe.edu.ulima.cookiemaker.model.RecetasManager


class RecipeRegistrationFragment(val username : String) : Fragment() {

    interface OnButtonClicked {
        fun onClick(button: String)
    }

    private var listener : OnButtonClicked? = null

    private var ingredients = arrayListOf<Ingrediente>()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnButtonClicked

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = this.arguments
        val ingredientName = args?.get("ingredient")
        if (ingredientName != null) {
            ingredients.add(Ingrediente(ingredientName.toString()))
        }
        return inflater.inflate(R.layout.fragment_recipe_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val but_save = view.findViewById<Button>(R.id.button_Save)
        val but_ingredient = view.findViewById<Button>(R.id.button_Ingredients)

        but_ingredient.setOnClickListener { _ : View ->
            listener?.onClick("ingredients")
        }

        val id = RecetasManager().getInstance().getRecetas().size+1
        val nombreReceta = view.findViewById<EditText>(R.id.editText_Recipe)

        but_save.setOnClickListener { _ : View ->
            if (nombreReceta.text.toString() == "") {
                Toast.makeText(activity, "Ingrese un nombre para la receta, por favor", Toast.LENGTH_LONG).show()
            }else if (ingredients.size == 0) {
                Toast.makeText(activity, "Necesita ingredientes para la receta", Toast.LENGTH_LONG).show()
            } else{
                val receta = Receta(id, nombreReceta.text.toString(), username, ingredients)
                RecetasManager().getInstance().addReceta(receta)
                listener?.onClick("recipe_details")
            }
        }

        val rviRecipe = view.findViewById<RecyclerView>(R.id.rviRecipeRegis)
        rviRecipe.adapter = RecipeIngredientsAdapter(ingredients)
    }
}