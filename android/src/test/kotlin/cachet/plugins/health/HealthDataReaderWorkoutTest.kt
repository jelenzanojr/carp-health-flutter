package cachet.plugins.health

import androidx.health.connect.client.records.ExerciseSessionRecord
import androidx.health.connect.client.records.metadata.Metadata
import java.time.Instant
import org.junit.Assert.assertEquals
import org.junit.Test

class HealthDataReaderWorkoutTest {
    @Test
    fun workoutDataPointIncludesTheHealthConnectRecordingMethod() {
        val record = ExerciseSessionRecord(
            startTime = Instant.parse("2026-01-01T10:00:00Z"),
            startZoneOffset = null,
            endTime = Instant.parse("2026-01-01T11:00:00Z"),
            endZoneOffset = null,
            metadata = Metadata.manualEntry(),
            exerciseType = ExerciseSessionRecord.EXERCISE_TYPE_RUNNING,
        )

        val point = workoutDataPoint(
            record = record,
            totalDistance = 0.0,
            totalEnergyBurned = 0.0,
            totalSteps = 0.0,
        )

        assertEquals(
            Metadata.RECORDING_METHOD_MANUAL_ENTRY,
            point["recording_method"],
        )
    }
}
