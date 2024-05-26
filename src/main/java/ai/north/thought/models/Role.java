package ai.north.thought.models;

import ai.north.thought.converters.RoleNames;
import ai.north.thought.converters.RoleNamesConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role_name", nullable = false, length = Integer.MAX_VALUE)
    @Convert(converter = RoleNamesConverter.class)
    private RoleNames roleName;

    @Override
    public String getAuthority() {
        return roleName.getAuthority();
    }
}