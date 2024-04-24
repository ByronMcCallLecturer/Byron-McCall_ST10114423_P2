package com.example.opsc

import android.app.Activity
import android.content.Intent
import android.os.Bundle

fun openIntent(activity: Activity, order: String, activityToOpen: Class<*>) {
    // declare intent with context and class to pass the value to
    val intent = Intent(activity, activityToOpen)

    // pass through the string value with key "order"
    intent.putExtra("order", order)

    // start the activity
    activity.startActivity(intent)

}

// -------------  Creating implicit intent to share the order  ---------------
/* Polymorphism is used to create two methods that will provide functionality to use implicit
intents to the app. This is because we can send a single value within an intent and an Extra
(putExtra) or we can send multiple values with a Bundle.
*/
// Start by sending just a single value to any application the user selects from the Android share
// sheet.
fun shareIntent(activity: Activity, order: String) {

    // create a new intent object for sending data
    var sendIntent = Intent()

    // sets the action of the intent to ACTION_SEND, indicating that the intent is used to send data
    sendIntent.setAction(Intent.ACTION_SEND)

    // adds the text message (order) to the intent as an extra, with the key EXTRA_TEXT
    // This extra is used by the app that receives the intent to retrieve the shared text
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)

    // sets the data that is being sent (think of setter in getters
    // and setters). In this case it is default
    sendIntent.setType("text/plain")

    // set up the share sheet
    // create a chooser intent that allows the user to select which app to use for sharing
    // the text message. sendIntent takes the original text and a title (null) for the
    // chooser dialogue. shareIntent provides the functionality to share the data
    var shareIntent = Intent.createChooser(sendIntent, null)

    // start the activity that shows the share sheet with the list of apps that can handle the
    // sendIntent. The user can choose an app to share the message
    activity.startActivity(shareIntent)
}

// Send a bundle of data to the android app
fun shareIntent(activity: Activity, order: Order) {
    var sendIntent = Intent()
    sendIntent.setAction(Intent.ACTION_SEND)

    // create a bundle and add multiple values to it
    // Bundle allows to send multiple values through an intent using key-value pairs.
    // each key represents the name of the data, along with the actual data itself
    var shareOrderDetails = Bundle()
    shareOrderDetails.putString("productName", order.productName)
    shareOrderDetails.putString("customerName", order.customerName)
    shareOrderDetails.putString("customerCell", order.customerCell)

    // share the whole bundle
    // EXTRA_TEXT allows the app to retrieve the shared data through the intent
    sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)

    // sets the data that is being set. In this case, it is default text at the moment
    sendIntent.setType("text/plain")

    // set up the share sheet
    var shareIntent = Intent.createChooser(sendIntent, null)
    activity.startActivity(shareIntent)

}
