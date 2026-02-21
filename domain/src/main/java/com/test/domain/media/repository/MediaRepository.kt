package com.test.domain.media.repository

import com.test.domain.media.model.Video

interface MediaRepository {
    suspend fun insertVideo(title: String?, videoUrl: String)
    suspend fun getAllVideos(): List<Video>
}