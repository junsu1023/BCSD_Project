package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.EquipmentEntity
import com.example.domain.model.isFailure
import com.example.domain.model.onSuccess
import com.example.domain.repository.ItemsResponse
import com.example.domain.usecase.firestore.AddItemUseCase
import com.example.domain.usecase.firestore.DeleteItemUseCase
import com.example.domain.usecase.firestore.GetItemUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WarehouseViewModel(
    private val addItemUseCase: AddItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    private val getItemUseCase: GetItemUseCase
): ViewModel() {

    init {
        getItem()
    }

    private fun getItem() = viewModelScope.launch {
        getItemUseCase().collect()
    }

    fun addItem(
        albumUri: String?,
        name : String,
        totalCnt: Int,
        currentCnt: Int
    ) = viewModelScope.launch {
        addItemUseCase(albumUri, name, totalCnt, currentCnt)
    }

    fun deleteITem(name : String) = viewModelScope.launch {
        deleteItemUseCase(name)
    }
}