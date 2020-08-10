package space.amaaal.thelastkingdomwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCharacters: RecyclerView
    private var list: ArrayList<Character> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "The Last Kingdom Characters"
        actionBar.setDisplayHomeAsUpEnabled(true)

        rvCharacters = findViewById(R.id.rv_characters)
        rvCharacters.setHasFixedSize(true)

        list.addAll(CharactersData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvCharacters.adapter = listHeroAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
