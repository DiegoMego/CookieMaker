package pe.edu.ulima.cookiemaker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.model.Ingrediente

class IngredientsListAdapter(
    private val ingredientsList : List<Ingrediente>,
    private val listener : (Ingrediente) ->  Unit) :
    RecyclerView.Adapter<IngredientsListAdapter.ViewHolder>() {
    class ViewHolder(
        view: View,
        val listener : (Ingrediente) -> Unit,
        val ingredientsList: List<Ingrediente>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val butIngredientName: TextView = view.findViewById(R.id.tvi_ingredients_name)
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Log.i("IngredientsFragment", "Click")
            listener(ingredientsList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_ingredient_item, parent, false)
        return  ViewHolder(view, listener, ingredientsList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.butIngredientName.text = ingredientsList[position].nombre
    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }
}
