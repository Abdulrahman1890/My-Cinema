package com.example.mycinema.second_screen.state

data class ShowTime(
    val id: Int,
    val timeSlot: String,
    val isActive: Boolean,
)

data class ShowDate(
    val id: Int,
    val dateNumber: String,
    val weekDay: String,
    val isActive: Boolean
)

data class Chair(
    val id: Int,
    val rowIndex: Int,
    val columnIndex: Int,
    val groupId: Int,
    val status: Status = Status.Available,
) {
    enum class Status {
        Available, Reserved, Occupied
    }
}

data class ChairGroup(
    val groupId: Int,
    val chairs: List<Chair>,
    val rowIndex: Int
) {
    val firstChair: Chair get() = chairs[0]
    val secondChair: Chair get() = chairs[1]

    fun getChairByColumn(columnIndex: Int): Chair? =
        chairs.find { it.columnIndex == columnIndex }
}