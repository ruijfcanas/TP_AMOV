package pt.isec.tp_amov.objects

import android.util.Log
import java.util.ArrayList

data class ShoppingList (var name: String, val id: Int) {
    val productList : MutableList<Product> = ArrayList()

    fun productExists(prod: Product): Boolean{
        return productList.contains(prod)
    }

    fun addProduct(prod: Product){
        productList.add(prod)
        Log.i("AddProduct","One product as been added")
    }

    fun removeProduct(ID: Int ){
        for (i in productList){
            if(i.id == ID) {
                productList.remove(i)
                Log.i("RemoveProduct","One product as been removed")
            }
        }
        Log.i("RemoveProduct","Failed trying to remove product")
    }

    override fun toString(): String {
        return name
    }
}