package ge.ezarkua.mvpdemo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @ColumnInfo(name = "name") val movieName: String,
    @ColumnInfo val rating: Float
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}