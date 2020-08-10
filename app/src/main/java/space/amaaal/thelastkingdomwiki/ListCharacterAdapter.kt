package space.amaaal.thelastkingdomwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(val listChars: ArrayList<Character>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_character, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val characterData = listChars[position]

        Glide.with(holder.itemView.context)
            .load(characterData.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = characterData.name
        holder.tvDetail.text = characterData.detail

        val thisContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetail = Intent(thisContext, CharacterScreenActivity::class.java)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_NAME, characterData.name)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_DETAIL, characterData.detail)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_PHOTO, characterData.photo)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_GENDER, characterData.gender)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_RESIDENCE, characterData.residence)
            moveDetail.putExtra(CharacterScreenActivity.EXTRA_RELATIVES, characterData.relatives)
            thisContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listChars.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}