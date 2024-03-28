package org.ebrahimi.notification;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private Long toProductId;
    private String message;
}
