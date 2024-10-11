package com.lab4.ui.screens.subjectDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lab4.data.db.Lab4Database
import com.lab4.data.entity.SubjectEntity
import com.lab4.data.entity.SubjectLabEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectDetailsViewModel(
    private val database: Lab4Database
) : ViewModel() {

    private val _subjectListStateFlow = MutableStateFlow<SubjectEntity?>(null)
    val subjectListStateFlow: StateFlow<SubjectEntity?>
        get() = _subjectListStateFlow

    private val _subjectLabsListStateFlow = MutableStateFlow<List<SubjectLabEntity>>(emptyList())
    val subjectLabsListStateFlow: StateFlow<List<SubjectLabEntity>>
        get() = _subjectLabsListStateFlow

    fun initData(id: Int) {
        viewModelScope.launch {
            _subjectListStateFlow.value = database.subjectsDao.getSubjectById(id)
            _subjectLabsListStateFlow.value = database.subjectLabsDao.getSubjectLabsBySubjectId(id)
        }
    }
}