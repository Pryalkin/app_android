package com.bsuir.spacex.sources.backend

import com.bsuir.spacex.sources.model.AppSource

interface SourcesProvider {

    fun getAppSource(): AppSource

}