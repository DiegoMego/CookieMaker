package pe.edu.ulima.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import pe.edu.ulima.cookiemaker.fragments.RecipeListFragment

class MainActivity : AppCompatActivity() {
    private var fragments : ArrayList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RecipeListFragment())
    }
}