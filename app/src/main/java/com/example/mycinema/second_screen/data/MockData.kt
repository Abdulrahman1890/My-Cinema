package com.example.mycinema.second_screen.data

import com.example.mycinema.second_screen.state.Chair
import com.example.mycinema.second_screen.state.ChairGroup
import com.example.mycinema.second_screen.state.ShowDate
import com.example.mycinema.second_screen.state.ShowTime

val mockChairs = listOf(
    Chair(id = 1, rowIndex = 1, columnIndex = 0, groupId = 1),
    Chair(id = 2, rowIndex = 1, columnIndex = 1, groupId = 1),

    Chair(id = 3, rowIndex = 2, columnIndex = 0, groupId = 2),
    Chair(id = 4, rowIndex = 2, columnIndex = 1, groupId = 2),

    Chair(id = 5, rowIndex = 3, columnIndex = 0, groupId = 3, status = Chair.Status.Occupied),
    Chair(id = 6, rowIndex = 3, columnIndex = 1, groupId = 3),

    Chair(id = 7, rowIndex = 1, columnIndex = 0, groupId = 4),
    Chair(id = 8, rowIndex = 1, columnIndex = 1, groupId = 4),

    Chair(id = 9, rowIndex = 2, columnIndex = 0, groupId = 5, status = Chair.Status.Reserved),
    Chair(id = 10, rowIndex = 2, columnIndex = 1, groupId = 5, status = Chair.Status.Reserved),

    Chair(id = 11, rowIndex = 3, columnIndex = 0, groupId = 6),
    Chair(id = 12, rowIndex = 3, columnIndex = 1, groupId = 6),

    Chair(id = 13, rowIndex = 1, columnIndex = 0, groupId = 7, status = Chair.Status.Occupied),
    Chair(id = 14, rowIndex = 1, columnIndex = 1, groupId = 7),

    Chair(id = 15, rowIndex = 2, columnIndex = 0, groupId = 8, status = Chair.Status.Reserved),
    Chair(id = 16, rowIndex = 2, columnIndex = 1, groupId = 8, status = Chair.Status.Reserved),

    Chair(id = 17, rowIndex = 3, columnIndex = 0, groupId = 9, status = Chair.Status.Occupied),
    Chair(id = 18, rowIndex = 3, columnIndex = 1, groupId = 9, status = Chair.Status.Occupied),

    Chair(id = 19, rowIndex = 1, columnIndex = 0, groupId = 10),
    Chair(id = 20, rowIndex = 1, columnIndex = 1, groupId = 10),

    Chair(id = 21, rowIndex = 2, columnIndex = 0, groupId = 11, status = Chair.Status.Occupied),
    Chair(id = 22, rowIndex = 2, columnIndex = 1, groupId = 11, status = Chair.Status.Occupied),

    Chair(id = 23, rowIndex = 3, columnIndex = 0, groupId = 12),
    Chair(id = 24, rowIndex = 3, columnIndex = 1, groupId = 12),

    Chair(id = 25, rowIndex = 1, columnIndex = 0, groupId = 13, status = Chair.Status.Occupied),
    Chair(id = 26, rowIndex = 1, columnIndex = 1, groupId = 13, status = Chair.Status.Occupied),

    Chair(id = 27, rowIndex = 2, columnIndex = 0, groupId = 14, status = Chair.Status.Occupied),
    Chair(id = 28, rowIndex = 2, columnIndex = 1, groupId = 14, status = Chair.Status.Occupied),

    Chair(id = 29, rowIndex = 3, columnIndex = 0, groupId = 15),
    Chair(id = 30, rowIndex = 3, columnIndex = 1, groupId = 15)
)

fun createChairGroups(chairs: List<Chair>): List<ChairGroup> {
    return chairs
        .groupBy { it.groupId }
        .map { (groupId, chairsInGroup) ->
            ChairGroup(
                groupId = groupId,
                chairs = chairsInGroup.sortedBy { it.columnIndex },
                rowIndex = chairsInGroup.first().rowIndex
            )
        }
        .sortedBy { it.groupId }
}

val mockShowDates = listOf(
    ShowDate(1, "14", "Thu", false),
    ShowDate(2, "15", "Fri", false),
    ShowDate(3, "16", "Sat", true),
    ShowDate(4, "17", "Sun", false),
    ShowDate(5, "18", "Mon", false),
    ShowDate(6, "19", "Tue", false),
    ShowDate(7, "20", "Wed", false),
    ShowDate(8, "21", "Thu", false),
    ShowDate(9, "22", "Fri", false),
    ShowDate(10, "23", "Sat", false),
)

val mockShowTimes = listOf(
    ShowTime(1, "10:00", true),
    ShowTime(2, "12:30", false),
    ShowTime(3, "15:30", false),
    ShowTime(4, "18:30", false),
    ShowTime(5, "21:30", false),
    ShowTime(6, "00:30", false),
    ShowTime(7, "04:00", false),
    ShowTime(8, "06:30", false),
    ShowTime(9, "08:30", false)
)
