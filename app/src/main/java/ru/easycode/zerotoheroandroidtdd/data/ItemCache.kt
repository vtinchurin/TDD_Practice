package ru.easycode.zerotoheroandroidtdd.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.easycode.zerotoheroandroidtdd.ItemUi
import ru.easycode.zerotoheroandroidtdd.domain.Item
import ru.easycode.zerotoheroandroidtdd.domain.Item.Mapper


@Entity("items")
data class ItemCache(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "text") val text: String,
) : Item {

    override fun <T : Item> map(mapper: Mapper<T>): T {
        return mapper.map(id, text)
    }
}


class ToUi : Mapper<ItemUi> {
    override fun map(id: Long, text: String): ItemUi {
        return ItemUi(id, text)
    }
}
