package pe.edu.ulima.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.adapter.RecipeListAdapter
import pe.edu.ulima.cookiemaker.model.Receta
import pe.edu.ulima.cookiemaker.model.RecetasManager

class RecipeListFragment : Fragment() {

    interface OnRecipeSelectListener {
        fun OnSelect(receta : Receta)
    }

    private var listener : OnRecipeSelectListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnRecipeSelectListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviRecipeList : RecyclerView = view.findViewById(R.id.rviRecipeList)
        rviRecipeList.adapter = RecipeListAdapter(
            RecetasManager().getInstance().getRecetas(),
        ) {
            receta : Receta ->
            listener?.OnSelect(receta)
        }

    }
}