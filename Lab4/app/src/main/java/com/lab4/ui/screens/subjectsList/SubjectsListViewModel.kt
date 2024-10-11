package com.lab4.ui.screens.subjectsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lab4.data.db.Lab4Database
import com.lab4.data.entity.SubjectEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectsListViewModel(
    private val database: Lab4Database
) : ViewModel() {

    private val _subjectListStateFlow = MutableStateFlow<List<SubjectEntity>>(emptyList())
    val subjectListStateFlow: StateFlow<List<SubjectEntity>>
        get() = _subjectListStateFlow


    init {
        viewModelScope.launch {
            _subjectListStateFlow.value = database.subjectsDao.getAllSubjects()
        }
    }
}