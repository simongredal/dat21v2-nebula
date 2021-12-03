package gruppe8.nebula.requests;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TaskUpdateRequest(
        Long id,
        Long projectId,
        Long parentId,
        String name,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
        Long duration,
        Long resourceId) {
}
