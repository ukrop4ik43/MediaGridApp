package com.test.data.local.repository

import com.test.data.AppDatabase
import com.test.data.local.mapper.toVideoEntity
import com.test.domain.media.model.Video
import com.test.domain.media.repository.MediaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MediaRepositoryImpl(private val database: AppDatabase) : MediaRepository {
    private val queries = database.appDatabaseQueries
    override suspend fun insertVideo(title: String?, videoUrl: String) {
        withContext(Dispatchers.IO) {
            queries.insertMediaEntity(url = videoUrl, title = title)
        }
    }


    override suspend fun getAllVideos(): List<Video> {
        return queries.selectAllEntries().executeAsList().map {
            it.toVideoEntity()
        }
    }
}