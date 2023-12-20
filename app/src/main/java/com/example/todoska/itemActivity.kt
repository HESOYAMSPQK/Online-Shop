package com.example.todoska

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class itemActivity : AppCompatActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_live_rzp_test_5U81WWQBOIMAmn")


        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val image: ImageView = findViewById(R.id.item_list_image_one)
        val btn: TextView = findViewById(R.id.button_buy)

        title.text= intent.getStringExtra("itemTitle")
        text.text= intent.getStringExtra("itemText")
        val imageName = intent.getStringExtra("itemImage")
        val imageId = resources.getIdentifier(imageName, "drawable", packageName)
        image.setImageResource(imageId)
        btn.setOnClickListener {
            startPayment()
        }

    }
    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Vah.oplati")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://e7.pngegg.com/pngimages/974/685/png-clipart-logo-brand-design-text-logo-thumbnail.png")
            options.put("theme.color", "#201E28");
            options.put("currency","RUB");
            options.put("order_id", "order_MexL2cEtWKi7Bg");
            options.put("amount",10000)


            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }
}