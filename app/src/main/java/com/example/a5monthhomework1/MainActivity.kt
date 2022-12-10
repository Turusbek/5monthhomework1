package com.example.a5monthhomework1
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a5monthhomework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           binding = ActivityMainBinding.inflate(layoutInflater)
           presenter.attachView(this)
           setContentView(binding.root)
           fromPresenter()
       }

       private fun fromPresenter(){
           binding.btnIncrement.setOnClickListener{
               presenter.incrementCount()
           }
           binding.btnDecrement.setOnClickListener{
               presenter.decrementCount()
           }
   }

    override fun updateCounter(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun setToast(count: Int) {
        if (count == 10){
            Toast.makeText(this,"Поздравляем",Toast.LENGTH_SHORT).show()
        }
    }

    override fun setColor(count: Int) {
        if (count == 15){
            binding.tvCount.setTextColor(Color.RED)
        }else{
            binding.tvCount.setTextColor(Color.BLACK)
        }
    }
    }