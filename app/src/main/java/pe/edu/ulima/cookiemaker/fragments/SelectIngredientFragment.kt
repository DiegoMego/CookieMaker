package pe.edu.ulima.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cookiemaker.R
import pe.edu.ulima.cookiemaker.adapter.IngredientsListAdapater
import pe.edu.ulima.cookiemaker.model.Ingrediente
import pe.edu.ulima.cookiemaker.model.RecetasManager

class SelectIngredientFragment : Fragment() {
    interface OnIngredientSelectedListener {
        fun OnSelect(ingredient : Ingrediente)
    }
    private var listener : OnIngredientSelectedListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnIngredientSelectedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_ingredient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rviIngredients = view.findViewById<RecyclerView>(R.id.rviIngredients)
        rviIngredients.adapter =
            IngredientsListAdapater(
                RecetasManager().getIngredientes()
            )  { ingredient : Ingrediente ->
                listener?.OnSelect(ingredient)
            }
    }
}