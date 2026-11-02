package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgressDao {
    @Query("SELECT * FROM user_progress WHERE id = 1 LIMIT 1")
    fun getUserProgress(): Flow<UserProgressEntity?>

    @Query("SELECT * FROM user_progress WHERE id = 1 LIMIT 1")
    suspend fun getUserProgressSync(): UserProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(progress: UserProgressEntity)
}

@Dao
interface VocabProgressDao {
    @Query("SELECT * FROM vocab_progress")
    fun getAllVocabProgress(): Flow<List<VocabProgressEntity>>

    @Query("SELECT * FROM vocab_progress WHERE wordId = :id LIMIT 1")
    suspend fun getVocabProgress(id: String): VocabProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(item: VocabProgressEntity)

    @Query("UPDATE vocab_progress SET isFavorite = :isFav WHERE wordId = :id")
    suspend fun updateFavorite(id: String, isFav: Boolean)

    @Query("UPDATE vocab_progress SET srsLevel = :level, lastReviewTimestamp = :time WHERE wordId = :id")
    suspend fun updateSrsLevel(id: String, level: Int, time: Long)
}

@Dao
interface QuizMistakeDao {
    @Query("SELECT * FROM quiz_mistakes ORDER BY lastMissedTimestamp DESC")
    fun getAllMistakes(): Flow<List<QuizMistakeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun recordMistake(mistake: QuizMistakeEntity)

    @Query("DELETE FROM quiz_mistakes WHERE questionId = :questionId")
    suspend fun removeMistake(questionId: String)

    @Query("DELETE FROM quiz_mistakes")
    suspend fun clearAllMistakes()
}
