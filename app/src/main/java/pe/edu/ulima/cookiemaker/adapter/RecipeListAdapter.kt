package pe.edu.ulima.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.model.Receta

class RecipeListAdapter(
    private val recipeList :List<Receta>,
    private val listener : (Receta) -> Unit) :
        RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
            class ViewHolder(
                view : View, val listener : (Receta) -> Unit, val recipeList: List<Receta>
            ) : RecyclerView.ViewHolder(view), View.OnClickListener {

                val tviRecipeId : TextView
                val iviRecipeImage : ImageView
                val tviRecipeName : TextView
                val tviUserName : TextView

                init {
                    tviRecipeId = view.findViewById(R.id.tviRecipeId)
                    iviRecipeImage = view.findViewById(R.id.iviRecipeImage)
                    tviRecipeName = view.findViewById(R.id.tviRecipeName)
                    tviUserName = view.findViewById(R.id.tviUserName)
                    view.setOnClickListener(this)
                }

                override fun onClick(v: View?) {
                    listener(recipeList[adapterPosition])
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_recipe_item, parent, false)

        return ViewHolder(view, listener, recipeList)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.tviRecipeName.text = recipeList[position].id.toString()
        holder.tviRecipeName.text = recipeList[position].nombre
        holder.tviUserName.text = recipeList[position].usuario
        holder.iviRecipeImage.setImageResource(R.drawable.galletas_1)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}