package pe.edu.ulima.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.R


class RecipeRegistrationFragment : Fragment() {

    interface OnButtonClicked {
        fun onClick(button: String)
    }

    private var listener : OnButtonClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnButtonClicked

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val but_save = view.findViewById<Button>(R.id.button_Save)
        val but_ingredient = view.findViewById<Button>(R.id.button_Ingredients)

        but_ingredient.setOnClickListener { _ : View ->
            listener?.onClick("ingredients")
        }

        but_save.setOnClickListener { _ : View ->
            listener?.onClick("recipe_details")
        }
    }
}