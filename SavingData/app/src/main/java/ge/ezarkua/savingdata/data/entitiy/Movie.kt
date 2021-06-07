package ge.ezarkua.savingdata.data.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val movieName: String,
    @ColumnInfo val rating: Float
){
   
}