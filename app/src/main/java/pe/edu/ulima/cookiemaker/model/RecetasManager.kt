package pe.edu.ulima.cookiemaker.model

class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()

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
        return null
    }

    fun getIngredientes() : List<Ingrediente> {
        return mIngredientes
    }
}