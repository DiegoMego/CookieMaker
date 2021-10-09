package pe.edu.ulima.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.model.Ingrediente

class RecipeIngredientsAdapter (private val ingredientsList : List<Ingrediente>) :
    RecyclerView.Adapter<RecipeIngredientsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val butIngredientName: TextView = view.findViewById(R.id.tvi_ingredients_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_ingredient_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.butIngredientName.text = ingredientsList[position].nombre
    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }
}