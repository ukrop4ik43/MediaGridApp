package com.test.mediagridapp.di

import com.test.data.AppDatabase
import com.test.data.base.AndroidResources
import com.test.data.local.db.DatabaseDriverFactory
import com.test.data.local.repository.MediaRepositoryImpl
import com.test.domain.base.AppResources
import com.test.domain.media.repository.MediaRepository
import com.test.feature_media.screens.list.ListViewModel
import com.test.feature_media.screens.record.RecordViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AppResources> { AndroidResources(get()) }
    single<MediaRepository> { MediaRepositoryImpl(get()) }
    single { DatabaseDriverFactory(get()) }
    single { AppDatabase(get<DatabaseDriverFactory>().createDriver()) }
    viewModel { ListViewModel(get()) }
    viewModel { RecordViewModel(get()) }
}