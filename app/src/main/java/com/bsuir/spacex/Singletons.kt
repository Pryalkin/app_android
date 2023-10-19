package com.bsuir.spacex

import android.content.Context
import com.bsuir.spacex.app.repository.AppRepository
import com.bsuir.spacex.sources.backend.SourcesProvider
import com.bsuir.spacex.app.setting.AppSettings
import com.bsuir.spacex.app.setting.SharedPreferencesAppSettings
import com.bsuir.spacex.app.views.AppViewModel
import com.bsuir.spacex.sources.SourceProviderHolder
import com.bsuir.spacex.sources.model.AppSource


object Singletons {

    private lateinit var appContext: Context

    private val sourcesProvider: SourcesProvider by lazy {
        SourceProviderHolder.sourcesProvider
    }

    val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(appContext)
    }

    // source
    private val appSource: AppSource by lazy {
        sourcesProvider.getAppSource()
    }

    // repository
    val appRepository: AppRepository by lazy {
        AppRepository(
            appSource = appSource
        )
    }

    // viewModel

    val appViewModel: AppViewModel by lazy {
        AppViewModel()
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }

}