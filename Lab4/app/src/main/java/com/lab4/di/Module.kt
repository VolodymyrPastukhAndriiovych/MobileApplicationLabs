package com.lab4.di

import android.content.Context
import androidx.room.Room
import com.lab4.data.db.Lab4Database
import com.lab4.ui.screens.subjectDetails.SubjectDetailsViewModel
import com.lab4.ui.screens.subjectsList.SubjectsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get<Context>(),
            Lab4Database::class.java, "lab4Database"
        ).build()
    }

    viewModel { SubjectsListViewModel(get<Lab4Database>()) }
    viewModel { SubjectDetailsViewModel(get<Lab4Database>()) }
}