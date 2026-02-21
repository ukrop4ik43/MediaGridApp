package com.test.data.base

import android.content.Context
import android.content.res.Resources
import androidx.core.content.ContextCompat
import com.test.domain.base.AppResources

class AndroidResources(
    private val context: Context
) : AppResources {

    private val res = context.resources

    override fun getBoolean(resourceId: Int): Boolean = res.getBoolean(resourceId)

    override fun getColor(resourceId: Int): Int = ContextCompat.getColor(context, resourceId)

    override fun getString(resourceId: Int): String = res.getString(resourceId)

    override fun getText(resourceId: Int): CharSequence = res.getText(resourceId)

    override fun getString(resourceId: Int, vararg arguments: Any?): String =
        res.getString(resourceId, *arguments)

    override fun getStringArray(resourceId: Int): Array<String> = res.getStringArray(resourceId)

    override fun getQuantityString(resourceId: Int, quantity: Int, vararg arguments: Any?): String =
        res.getQuantityString(resourceId, quantity, *arguments)
}