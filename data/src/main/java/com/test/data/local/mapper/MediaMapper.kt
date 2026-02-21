package com.test.data.local.mapper

import com.test.data.MediaEntity
import com.test.domain.media.model.Video

fun MediaEntity.toVideoEntity(): Video {
    return Video(url = this.url, title = this.title)
}