package ru.easycode.zerotoheroandroidtdd.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("items")
data class ItemCache(
    @PrimaryKey @ColumnInfo (name = "id")val id: Long,
    @ColumnInfo(name = "text")val text: String,
)


