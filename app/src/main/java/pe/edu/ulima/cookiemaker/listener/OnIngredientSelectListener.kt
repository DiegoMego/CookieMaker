package pe.edu.ulima.cookiemaker.listener

import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

interface OnIngredientSelectListener {
    fun OnSelect(ingredient : Ingrediente)
}