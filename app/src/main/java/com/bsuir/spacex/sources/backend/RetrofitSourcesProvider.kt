package com.bsuir.spacex.sources.backend

import com.bsuir.spacex.sources.model.AppSource
import com.bsuir.spacex.sources.model.RetrofitAppSource

class RetrofitSourcesProvider(
    private val config: RetrofitConfig
) : SourcesProvider {

    override fun getAppSource(): AppSource {
        return RetrofitAppSource(config)
    }

}