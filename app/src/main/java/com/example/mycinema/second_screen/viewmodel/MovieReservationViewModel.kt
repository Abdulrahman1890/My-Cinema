package com.example.mycinema.second_screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycinema.second_screen.data.createChairGroups
import com.example.mycinema.second_screen.data.mockChairs
import com.example.mycinema.second_screen.data.mockShowDates
import com.example.mycinema.second_screen.data.mockShowTimes
import com.example.mycinema.second_screen.state.Chair
import com.example.mycinema.second_screen.state.ChairGroup
import com.example.mycinema.second_screen.state.ShowDate
import com.example.mycinema.second_screen.state.ShowTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieReservationViewModel : ViewModel() {

    private val _chairs = MutableStateFlow<List<Chair>>(emptyList())
    val chairs: StateFlow<List<Chair>> = _chairs.asStateFlow()

    private val _chairGroups = MutableStateFlow<List<ChairGroup>>(emptyList())
    val chairGroups: StateFlow<List<ChairGroup>> = _chairGroups.asStateFlow()

    private val _showDates = MutableStateFlow<List<ShowDate>>(emptyList())
    val showDates: StateFlow<List<ShowDate>> = _showDates.asStateFlow()

    private val _showTimes = MutableStateFlow<List<ShowTime>>(emptyList())
    val showTimes: StateFlow<List<ShowTime>> = _showTimes.asStateFlow()

    private val _selectedSeatsCount = MutableStateFlow(0)
    val selectedSeatsCount: StateFlow<Int> = _selectedSeatsCount.asStateFlow()

    private val reservedSeatsRegistry = mutableSetOf<Int>()

    fun initializeBookingData() {
        _chairs.value = mockChairs
        _chairGroups.value = createChairGroups(mockChairs)
        _showDates.value = mockShowDates
        _showTimes.value = mockShowTimes
        calculateInitialReservations()
    }

    fun handleChairSelection(chairId: Int) {
        val updatedChairs = _chairs.value.map { chair ->
            if (chair.id == chairId) {
                chair.switchAvailability().also { updatedChair ->
                    updateReservationRegistry(updatedChair)
                }
            } else {
                chair
            }
        }

        _chairs.value = updatedChairs
        _chairGroups.value = createChairGroups(updatedChairs)
    }

    fun handleDateSelection(dateId: Int) {
        _showDates.value = _showDates.value.map { date ->
            date.copy(isActive = date.id == dateId)
        }
    }

    fun handleTimeSelection(timeId: Int) {
        _showTimes.value = _showTimes.value.map { time ->
            time.copy(isActive = time.id == timeId)
        }
    }

    private fun calculateInitialReservations() {
        _chairs.value.forEach { chair ->
            if (chair.status == Chair.Status.Reserved) {
                reservedSeatsRegistry.add(chair.id)
            }
        }
        _selectedSeatsCount.value = reservedSeatsRegistry.size
    }

    private fun updateReservationRegistry(chair: Chair) {
        when (chair.status) {
            Chair.Status.Reserved -> {
                reservedSeatsRegistry.add(chair.id)
            }

            Chair.Status.Available -> {
                reservedSeatsRegistry.remove(chair.id)
            }

            else -> {}
        }
        _selectedSeatsCount.value = reservedSeatsRegistry.size
    }

    private fun Chair.switchAvailability(): Chair {
        return when (status) {
            Chair.Status.Available -> copy(status = Chair.Status.Reserved)
            Chair.Status.Reserved -> copy(status = Chair.Status.Available)
            Chair.Status.Occupied -> this
        }
    }

    fun getChairById(chairId: Int): Chair? {
        return _chairs.value.find { it.id == chairId }
    }

    fun getChairGroupById(groupId: Int): ChairGroup? {
        return _chairGroups.value.find { it.groupId == groupId }
    }
}