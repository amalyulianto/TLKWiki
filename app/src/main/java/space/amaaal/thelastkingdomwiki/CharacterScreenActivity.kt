package space.amaaal.thelastkingdomwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CharacterScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_screen)

        val tvSetName: TextView = findViewById(R.id.tv_character_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_character_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_character_detail)
        val tvSetGender: TextView = findViewById(R.id.tv_character_gender)
        val tvSetResidence: TextView = findViewById(R.id.tv_character_residence)
        val tvSetRelatives: TextView = findViewById(R.id.tv_character_relatives)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tImg = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tGender  = intent.getStringExtra(EXTRA_GENDER)
        val tResidence  = intent.getStringExtra(EXTRA_RESIDENCE)
        val tRelatives = intent.getStringExtra(EXTRA_RELATIVES)


        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetail.text = tDetail
        tvSetGender.text = tGender
        tvSetResidence.text = tResidence
        tvSetRelatives.text = tRelatives


        val actionBar = supportActionBar
        actionBar!!.title = tName
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_RESIDENCE = "extra_residence"
        const val EXTRA_RELATIVES = "extra_relatives"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
