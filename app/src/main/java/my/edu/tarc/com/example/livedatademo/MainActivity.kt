package my.edu.tarc.com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import my.edu.tarc.com.example.livedatademo.databinding.ActivityMainBinding
import my.edu.tarc.com.example.livedatademo.models.AccountModel

class MainActivity : AppCompatActivity() {
     private val myAccout = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myAccount = myAccout
        binding.lifecycleOwner = this
        //display()

        //monitor latest data
        myAccout.balance.observe(this, Observer {newBalance -> binding.tvBalance.text = newBalance.toString() })


        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.deposit(amount)

            //myAccout.balance.value = -100000.00
            //update the display result
            //binding.tvBalance.text = myAccout.balance.toString()

        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.withdraw(amount)
            //binding.tvBalance.text = myAccout.balance.toString()

        }
    }

//    fun display(){
//
//        binding.tvAccNo.text = myAccout.accNo
//        binding.tvName.text = myAccout.owner
//        binding.tvBalance.text = myAccout.balance.value.toString()
//
//    }
}