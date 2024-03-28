package org.ebrahimi.notification.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="notifications")
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long notificationId;

    @Column(name="message")
    private String message;
    @Column(name="sender")
    private String sender;
    @Column(name="sendAt")
    private LocalDateTime sendAt;

}
