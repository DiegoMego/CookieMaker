package pe.edu.ulima.cookiemaker.model

import pe.edu.ulima.cookiemaker.R

class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()
    public val mRecetasImagenes = arrayListOf<Int>(
        R.drawable.galletas_1, R.drawable.galletas_2, R.drawable.galletas_3, R.drawable.galletas_4
    )

    init {
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
        mIngredientes.add(Ingrediente("Leche"))
        mIngredientes.add(Ingrediente("Chocolate"))
        mIngredientes.add(Ingrediente("Huevo"))
        mIngredientes.add(Ingrediente("Ralladura de piel de naranja"))
        mIngredientes.add(Ingrediente("Ralladura de piel de limon"))
    }

    companion object {
        private var instance : RecetasManager? = null
    }

    fun getInstance() : RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas() : List<Receta> {
        return mRecetas
    }

    fun addReceta(receta : Receta) {
        mRecetas.add(receta)
    }

    fun getReceta(id : Int) : Receta? {
        return mRecetas.filter { it.id == id }.firstOrNull()
    }

    fun getIngredientes() : List<Ingrediente> {
        return mIngredientes
    }
}