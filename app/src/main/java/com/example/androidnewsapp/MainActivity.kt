package com.example.androidnewsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title


        imageList.add(SlideModel(R.drawable.garuda, "Illuminati."))
        imageList.add(SlideModel(R.drawable.one, "The animal population decreased by 58 percent in 42 years."))
        imageList.add(SlideModel(R.drawable.two, "Elephants and tigers may become extinct."))
        imageList.add(SlideModel(R.drawable.three, "And people do that."))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.startSliding(3000) // with new period
        imageSlider.startSliding()
        imageSlider.stopSliding()

        val dataGambar = arrayListOf(getDrawable((R.drawable.one)), getDrawable(R.drawable.two), getDrawable(R.drawable.three), getDrawable(R.drawable.garuda))

        val dataJudul = arrayListOf(
            "Where can i get some?",
            "What is Lorem Ipsum?",
            "Why do we use it?",
            "Garuda adalah illuminati?")

        val dataDeskripsi = arrayListOf(
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            "Garuda berawal dalam mitologi Hindu, yang merupakan burung dan kendaraan Dewa Wisnu. Dalam Regweda atau Rigveda, kisah mitologis tentang kelahiran Garuda di Mahabharata merupakan adik lelaki dari Aruna. Aruna adalah kusir dewa matahari (Surya) dan ibu Garuda adalah Vinata yang merupakan ibu dari burung-burung.")

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecyclerView(this,dataGambar, dataJudul, dataDeskripsi)
        recyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}