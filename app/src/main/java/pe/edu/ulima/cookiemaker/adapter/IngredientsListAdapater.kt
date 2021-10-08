package pe.edu.ulima.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.model.Ingrediente

class IngredientsListAdapater(
    private val ingredientsList : List<Ingrediente>,
    private val fragment : Fragment,
    private val listener : (Ingrediente) ->  Unit) :
    RecyclerView.Adapter<IngredientsListAdapater.ViewHolder>() {
        class ViewHolder(
            view: View,
            val listener : (Ingrediente) -> Unit,
            val ingredientsList: List<Ingrediente>
            ) : RecyclerView.ViewHolder(view), View.OnClickListener {

                val butIngredientName: Button

                init {
                    butIngredientName = view.findViewById(R.id.button_Ingredients_Name)
                    view.setOnClickListener(this)
                }

                override fun onClick(v: View?) {
                    listener(ingredientsList[adapterPosition])
                }
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).
            inflate(R.layout.fragment_ingredient_item, parent, false)
            return  ViewHolder(view, listener, ingredientsList)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.butIngredientName.text = ingredientsList[position].nombre
        }

        override fun getItemCount(): Int {
            return ingredientsList.size
        }
    }
