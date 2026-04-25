package org.example.day1

//interface MessageSender {
//    fun sendMessage(message: String)
//}
//
//class EmailSender: MessageSender {
//    override fun sendMessage(message: String) {
//        println("EMAIL: $message")
//    }
//}
//
//class SmsSender: MessageSender {
//    override fun sendMessage(message: String) {
//        println("SMS: $message")
//    }
//}
//
//class DeliveryAlert(
//    private val trackingId: String,
//    private val messageWorker: MessageSender
//) : MessageSender by messageWorker {
//
//    fun sendTrackingUpdate(status: String) {
//        sendMessage("Delivery $trackingId is now $status")
//    }
//
//    override fun sendMessage(message: String) {
//        println("[DeliveryAlert]")
//        messageWorker.sendMessage(message)
//    }
//}
//
//fun main() {
//    val bikeAlert = DeliveryAlert("BIKE-001", EmailSender())
//    bikeAlert.sendTrackingUpdate("OUT_FOR_DELIVERY")
//
//    val vanAlert = DeliveryAlert("VAN-001", SmsSender())
//    vanAlert.sendTrackingUpdate("DELIVERY")
//}