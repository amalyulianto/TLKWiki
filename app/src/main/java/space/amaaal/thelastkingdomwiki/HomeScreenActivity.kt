package space.amaaal.thelastkingdomwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val actionBar = supportActionBar
        actionBar!!.title = "The Last Kingdom Wiki"

        val buttonAbout: Button = findViewById(R.id.button_series)
        val buttonList: Button = findViewById(R.id.button_characters)

        buttonAbout.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SeriesOverviewActivity::class.java)
            startActivity(intent);
        }
        buttonList.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                val iAbout = Intent(this, AboutScreenActivity::class.java)
                startActivity(iAbout)
            }
        }
    }
}
