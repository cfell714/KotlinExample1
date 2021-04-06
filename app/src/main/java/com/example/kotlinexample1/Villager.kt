package com.example.kotlinexample1


// data class ClassName (val x:Type, val y:Type)
data class Villager (val name:String, val birthday:String, val phrase:String,
                      val houseURL:String, val villagerUrl:String, var showHouse:Boolean = true){
    // toString
        // Villager(name="Henry", birthday="...",...)
    // getters
    // setters
    // equals
}

// val -> do not come with setters

// var -> comes with setters and getters